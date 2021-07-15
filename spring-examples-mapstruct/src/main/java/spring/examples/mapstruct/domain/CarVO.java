package spring.examples.mapstruct.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarVO implements Serializable {

    private String make;
    private int seatCount;
    private String type;

}
