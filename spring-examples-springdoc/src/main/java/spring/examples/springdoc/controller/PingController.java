package spring.examples.springdoc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PingController {

    @Operation(summary = "测试用", security = @SecurityRequirement(name = HttpHeaders.AUTHORIZATION))
    @GetMapping("ping")
    String ping() {
        return "pong";
    }

}
