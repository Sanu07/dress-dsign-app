package com.fashion.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fashion.exceptions.ValueParseException;

class ReferenceIDGeneratorTest {

	@Test
	void testGetGeneratedId() {
		ValueParseException valueParseException = assertThrows(ValueParseException.class, () -> {
			ReferenceIDGenerator.getGeneratedId("David Warner", "AQWE123454");
		});
		assertTrue(valueParseException.getMessage().contains("Phone Number should be valid 10 digits value"));
		assertEquals("DW1234567890", ReferenceIDGenerator.getGeneratedId("David Warner", "1234567890"));
		assertEquals("D1234567890", ReferenceIDGenerator.getGeneratedId("David", "1234567890"));
	}

}
