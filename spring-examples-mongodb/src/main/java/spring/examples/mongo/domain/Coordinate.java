package spring.examples.mongo.domain;

import lombok.*;

/**
 * 坐标
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Coordinate {

    /**
     * 经度
     */
    private Double lng;

    /**
     * 纬度
     */
    private Double lat;

}
