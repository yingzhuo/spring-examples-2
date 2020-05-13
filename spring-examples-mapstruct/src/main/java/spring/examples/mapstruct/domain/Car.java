package spring.examples.mapstruct.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {

    private String make;
    private int numberOfSeats;
    private CarType type;


}
