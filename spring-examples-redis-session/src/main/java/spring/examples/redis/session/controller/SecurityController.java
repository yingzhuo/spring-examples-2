package spring.examples.redis.session.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @GetMapping("/login")
    public String login() {
        SecurityUtils.getSubject().login(new UsernamePasswordToken("yingzhuo", "12345", false));
        return "ok";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "ok";
    }

    @GetMapping("/info")
    public String info() {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        System.out.println(principal.getClass().getName());
        return "ok";
    }

}
