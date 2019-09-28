package spring.examples.protobuf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.examples.protobuf.proto.Proto;

@RestController
public class ProtoController {

    @GetMapping(path = "/proto", produces = "application/x-protobuf")
    public Object proto() {

        return Proto.UserList.newBuilder()
                .addUser(Proto.User.newBuilder()
                        .setId("1")
                        .setName("应卓")
                        .setGender(Proto.Gender.MALE)
                );
    }

}
