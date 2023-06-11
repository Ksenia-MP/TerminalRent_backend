package com.example.terminalrent.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ConnConverter implements AttributeConverter<Connection, String> {

    @Override
    public String convertToDatabaseColumn(Connection attribute) {
        if (attribute == null)
            return null;

        return attribute.getCode();
    }

    @Override
    public Connection convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        return Stream.of(Connection.values())
                .filter(c -> c.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
