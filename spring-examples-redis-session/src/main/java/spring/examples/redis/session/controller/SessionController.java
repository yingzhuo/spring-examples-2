package spring.examples.redis.session.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.examples.redis.session.domain.User;
import spring.examples.redis.session.security.Principal;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/session")
@Deprecated
public class SessionController {

    @GetMapping("/set")
    public String set(HttpSession session) {

        final User user = new User();
        user.setId("1");
        user.setUsername("应卓");
        user.setPassword("133810");

        final Principal principal = Principal.of(user, "ROLE_ADMIN");

        session.setAttribute("principal", principal);

        return "ok";
    }

    @GetMapping("/get")
    public String get(HttpSession session) {
        Principal principal = (Principal) session.getAttribute("principal");
        System.out.println(principal.getUser().getUsername());
        return "ok";
    }

}
