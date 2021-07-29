package spring.examples.springdoc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.examples.springdoc.domain.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Slf4j
@RestController
@RequestMapping("/user")
@Validated
class UserController {

    @PostMapping
    @Operation(summary = "创建新用户", security = @SecurityRequirement(name = HttpHeaders.AUTHORIZATION))
    User createUser(
            @Validated @RequestBody UserVO vo, BindingResult bindingResult) {
        return User.builder()
                .id(1L)
                .name(vo.getUsername())
                .password(vo.getPassword())
                .build();
    }

    @Getter
    @Setter
    private static final class UserVO implements Serializable {

        //        @NotNull
        @NotBlank
        @Size(min = 1, max = 10)
        @Schema(description = "用户名", example = "admin")
        private String username;

        @NotNull
        @Size(min = 1, max = 10)
        @Schema(description = "口令", example = "Password01！")
        private String password;
    }

}
