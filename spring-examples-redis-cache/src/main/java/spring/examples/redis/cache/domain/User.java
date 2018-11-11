package spring.examples.redis.cache.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {

    private String id;

    private Name name;

}
