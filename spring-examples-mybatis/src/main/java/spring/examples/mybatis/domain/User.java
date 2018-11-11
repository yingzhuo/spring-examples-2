package spring.examples.mybatis.domain;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -6617776798258361317L;

    private String id;
    private String username;
    private LocalDate dob;

}
