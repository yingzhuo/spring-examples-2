package spring.examples.jpa.domain;

import lombok.Getter;
import lombok.Setter;
import spring.examples.jpa.converter.RoleConverter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 32)
    private String password;

    @Column(name = "role")
    @Convert(converter = RoleConverter.class)
    private Role role;

}
