package spring.examples.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 2931750225998527316L;

    @Id
    @Column(name = "id", length = 32)
    private String id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 32)
    private String password;

}
