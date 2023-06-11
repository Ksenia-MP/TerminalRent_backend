package com.example.terminalrent.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatesConverter implements AttributeConverter<States, String> {

    @Override
    public String convertToDatabaseColumn(States attribute) {
        if (attribute == null)
            return null;

        return attribute.getCode();
    }

    @Override
    public States convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        return Stream.of(States.values())
                .filter(c -> c.getCode().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
