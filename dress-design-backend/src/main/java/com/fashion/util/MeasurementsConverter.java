package com.fashion.util;

import java.io.IOException;
import java.util.Map;

import javax.persistence.AttributeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fashion.entity.Measurements;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MeasurementsConverter implements AttributeConverter<Map<String, Measurements>, String> {

	private final Logger logger = LoggerFactory.getLogger(MeasurementsConverter.class);

	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Map<String, Measurements> measurementsInfo) {
		String measurementsInfoJson = null;
		try {
			measurementsInfoJson = objectMapper.writeValueAsString(measurementsInfo);
		} catch (final JsonProcessingException e) {
			logger.error("JSON parsing error", e);
		}
		return measurementsInfoJson;
	}

	@Override
	public Map<String, Measurements> convertToEntityAttribute(String measurementsInfoJson) {
		Map<String, Measurements> measurementsInfo = null;
		try {
			measurementsInfo = objectMapper.readValue(measurementsInfoJson, Map.class);
		} catch (final IOException e) {
			logger.error("JSON reading error", e);
		}
		return measurementsInfo;
	}
}
