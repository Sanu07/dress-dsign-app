package com.fashion.util;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fashion.enumutil.DressType;

@Converter(autoApply = true)
public class DressTypeConverter implements AttributeConverter<DressType, String> {

	@Override
	public String convertToDatabaseColumn(DressType dressType) {
		if (dressType == null) {
			return null;
		}
		return dressType.getDressType();
	}

	@Override
	public DressType convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		return Stream.of(DressType.values()).filter(type -> type.getDressType().equalsIgnoreCase(dbData)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
