package spring.examples.graphql.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Author implements Serializable {

    private Integer id;
    private String name;

}
