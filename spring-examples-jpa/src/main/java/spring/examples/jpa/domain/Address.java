package spring.examples.jpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "t_address")
public class Address implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "details")
    private String details;

}
