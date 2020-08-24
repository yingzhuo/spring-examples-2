package spring.examples.jpa.converter;

import spring.examples.jpa.domain.Role;

import javax.persistence.AttributeConverter;

public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role attribute) {
//        if (attribute == null) return null;
        return attribute.toString();
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
//        if (dbData == null) return null;
        return new Role(dbData);
    }

}
