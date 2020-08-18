package spring.examples.resttemplate.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {

    private String name;
    private String email;

}
