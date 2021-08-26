package spring.examples.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
class ApplicationBootSecurity extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTION"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    RoleHierarchy roleHierarchy() {
        final RoleHierarchyImpl rh = new RoleHierarchyImpl();
        rh.setHierarchy("ROLE_ADMIN > ROLE_ACTUATOR > ROLE_USER");
        return rh;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(
                        User.builder()
                                .username("admin")
                                .password("{MD5}21232f297a57a5a743894a0e4a801fc3")  // admin
                                .roles("ADMIN")
                                .build()
                )
                .withUser(
                        User.builder()
                                .username("actuator")
                                .password("{noop}actuator")
                                .roles("ACTUATOR")
                                .build()
                )
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.csrf()
                .disable();

        http.cors(Customizer.withDefaults());

        http.httpBasic();

        http.jee()
                .disable();

        http.formLogin()
                .disable();

        http.logout()
                .disable();

        http.rememberMe()
                .disable();

        http.x509()
                .disable();

        http.requestCache()
                .disable();

        http.anonymous();

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/actuator/info", "/actuator/health").permitAll()
                .antMatchers(HttpMethod.POST, "/actuator/shutdown").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/actuator/**").hasAnyRole("ACTUATOR")
                .antMatchers("/**").authenticated();

        http.exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.setStatus(HttpServletResponse.SC_UNAUTHORIZED));
    }

}
