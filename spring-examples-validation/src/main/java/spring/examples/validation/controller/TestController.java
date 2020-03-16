package spring.examples.validation.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(@Validated VO vo, Errors errors) {
        for (ObjectError objectError : errors.getAllErrors()) {
            System.out.println(objectError.getDefaultMessage());
        }
        return "ok";
    }

    public static class VO implements Serializable {
        @NotEmpty(message = "{i18n.fuckyou}")
        private String username;
        @NotEmpty(message = "{i18n.fuckyou}")
        private String password;
    }

}
