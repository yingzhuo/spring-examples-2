package spring.examples.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 坐标
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
