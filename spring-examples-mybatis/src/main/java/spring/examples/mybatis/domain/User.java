package spring.examples.mybatis.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = -6617776798258361317L;

    private String id;
    private String username;

}
