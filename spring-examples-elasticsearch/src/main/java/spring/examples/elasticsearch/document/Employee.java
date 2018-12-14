package spring.examples.elasticsearch.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "spring_examples_es", type = "employee")
public class Employee implements Serializable {

    @Id
    private String id;

    private String name;

    private Integer age;

}
