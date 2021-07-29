package com.fashion.util;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fashion.exceptions.ValueParseException;

public class ReferenceIDGenerator {

	final static Logger logger = LoggerFactory.getLogger(ReferenceIDGenerator.class);

	public static String getGeneratedCustomerId(String fullName, String phone) {

		if (!StringUtils.isNumeric(phone) || StringUtils.length(phone) != 10)
			throw new ValueParseException(
					"ReferenceIDGenerator::getGeneratedId -> Phone Number should be valid 10 digits value",
					new String[] { phone });
		return StringUtils.join(WordUtils.initials(fullName, null), phone);
	}
	
	public static String getGeneratedIdOrderId(String customerName) {
		Long randomTenDigNumber = 10000000L + ThreadLocalRandom.current().nextInt(1, 100) * 37;
		return StringUtils.join(WordUtils.initials(customerName, null), "OR" + String.valueOf(randomTenDigNumber));
	}
}
