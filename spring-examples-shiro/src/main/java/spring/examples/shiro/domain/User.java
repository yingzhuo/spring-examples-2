package spring.examples.shiro.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {

    private String id;
    private String username;
    private String password;

}
