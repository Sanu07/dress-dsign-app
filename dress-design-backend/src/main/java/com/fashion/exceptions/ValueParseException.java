package com.fashion.exceptions;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValueParseException extends RuntimeException {

	Logger logger = LoggerFactory.getLogger(ValueParseException.class);

	private static final long serialVersionUID = 1L;

	public ValueParseException(String message, String[] params) {
		super(message);
		String errorParams = StringUtils.join(params, ",");
		logger.error(message, errorParams);
	}

}
