package spring.examples.mongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User implements Serializable {

    private static final long serialVersionUID = 7600608129371779322L;

    @Id
    private Long id;

    private String username;

    private String gender;

    private Coordinate coordinate;

}
