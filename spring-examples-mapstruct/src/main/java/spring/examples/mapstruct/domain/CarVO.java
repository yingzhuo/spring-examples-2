package spring.examples.mapstruct.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarVO implements Serializable {

    private String make;
    private int seatCount;
    private String type;

}
