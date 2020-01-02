package spring.examples.redis.session.security;

import spring.examples.redis.session.domain.User;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public interface Principal extends Serializable {

    public static Principal of(User user, String... roles) {
        Objects.requireNonNull(user);
        Objects.requireNonNull(roles);

        SimplePrincipal principal = new SimplePrincipal();
        principal.setUser(user);
        principal.setRoles(Arrays.asList(roles));
        return principal;
    }

    public User getUser();

    public List<String> getRoles();

    // ----------------------------------------------------------------------------------------------------------------

    public static final class SimplePrincipal implements Principal {

        private User user;
        private List<String> roles;

        @Override
        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        @Override
        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }
    }

}
