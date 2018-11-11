package spring.examples.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @GetMapping("/login")
    public String login() {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken("yingzhuo", "123456", false));
            return "ok";
        } catch (AuthenticationException e) {
            return "ng";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "ok";
    }

}
