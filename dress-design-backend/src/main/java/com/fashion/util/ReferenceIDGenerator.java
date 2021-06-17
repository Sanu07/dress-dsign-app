package com.fashion.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fashion.exceptions.ValueParseException;

public class ReferenceIDGenerator {

	final static Logger logger = LoggerFactory.getLogger(ReferenceIDGenerator.class);

	public static String getGeneratedId(String fullName, String phone) {

		if (!StringUtils.isNumeric(phone) || StringUtils.length(phone) != 10)
			throw new ValueParseException(
					"ReferenceIDGenerator::getGeneratedId -> Phone Number should be valid 10 digits value",
					new String[] { phone });
		String generatedID = StringUtils.join(WordUtils.initials(fullName, null), phone);
		return generatedID;
	}

}
