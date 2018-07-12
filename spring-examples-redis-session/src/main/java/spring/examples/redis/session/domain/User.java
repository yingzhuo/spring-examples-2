package spring.examples.redis.session.domain;

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
