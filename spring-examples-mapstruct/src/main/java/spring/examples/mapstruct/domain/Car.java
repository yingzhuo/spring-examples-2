package spring.examples.mapstruct.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {

    private String make;
    private int numberOfSeats;
    private CarType type;

}
