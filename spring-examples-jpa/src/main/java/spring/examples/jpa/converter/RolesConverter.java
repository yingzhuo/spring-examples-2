package spring.examples.jpa.converter;

import spring.examples.jpa.domain.Roles;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.List;

public class RolesConverter implements AttributeConverter<Roles, String> {

    @Override
    public String convertToDatabaseColumn(Roles attribute) {

        if (attribute == null || attribute.isEmpty()) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>(attribute.toSet());
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
            if (i != list.size() - 1) {
                builder.append(',');
            }
        }

        return builder.toString();
    }

    @Override
    public Roles convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return new Roles(dbData.split(","));
    }

}
