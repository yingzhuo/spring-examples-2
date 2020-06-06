package spring.examples.redis.cache.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Name implements Serializable {

    private String firstName;
    private String lastName;

    public static Name of(String firstName, String lastName) {
        Name name = new Name();
        name.setFirstName(firstName);
        name.setLastName(lastName);
        return name;
    }

}
