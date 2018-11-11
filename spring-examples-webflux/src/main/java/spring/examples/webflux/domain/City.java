package spring.examples.webflux.domain;

import lombok.*;

import java.io.Serializable;

/**
 * 城市
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {

    private static final long serialVersionUID = -7536202963661042729L;

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;

}
