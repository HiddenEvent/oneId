package me.ricky.aggregate.common.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToYNConverter implements AttributeConverter<Boolean, String> {
	
	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		return (attribute != null && attribute) ? "Y" : "N";
	}
	
	@Override
	public Boolean convertToEntityAttribute(String s) {
	    return "Y".equals(s);
    }
}