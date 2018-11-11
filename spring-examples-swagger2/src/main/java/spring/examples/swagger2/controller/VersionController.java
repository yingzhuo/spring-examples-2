package spring.examples.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "版本信息")
public class VersionController {

    @GetMapping("/version")
    @ApiOperation(response = String.class, value = "当前版本")
    public String version() {
        return "1.0.1";
    }

}
