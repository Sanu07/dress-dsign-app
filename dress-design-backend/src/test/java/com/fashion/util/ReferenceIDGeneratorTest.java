package com.fashion.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fashion.exceptions.ValueParseException;

@ExtendWith(MockitoExtension.class)
class ReferenceIDGeneratorTest {

	@Test
	@DisplayName("Should generate and return properly formatted ID")
	void testGetGeneratedId() {
		assertEquals("DW1234567890", ReferenceIDGenerator.getGeneratedId("David Warner", "1234567890"));
		assertEquals("D1234567890", ReferenceIDGenerator.getGeneratedId("David", "1234567890"));
	}
	
	@Test
	@DisplayName("Should return only 10 digits phone number when fullname is null")
	void testGeneratedId_with_nullValues() {
		assertEquals("1234567890", ReferenceIDGenerator.getGeneratedId(null, "1234567890"));
	}
	
	@Test
	@DisplayName("Should return Value Parse exception when phone is less than 10 digits")
	void testGeneratedId_with_phone_lessThan10() {
		ValueParseException valueParseException = assertThrows(ValueParseException.class, () -> {
			ReferenceIDGenerator.getGeneratedId("David Warner", "12345");
		});
		assertTrue(valueParseException.getMessage().contains("Phone Number should be valid 10 digits value"));
	}
	
	@Test
	@DisplayName("Should return ValueParseException when phone is invalid")
	void shouldReturnException_when_phoneIsInvalid() {
		ValueParseException valueParseException = assertThrows(ValueParseException.class, () -> {
			ReferenceIDGenerator.getGeneratedId("David Warner", "AQWE123454");
		});
		assertTrue(valueParseException.getMessage().contains("Phone Number should be valid 10 digits value"));
	}
}
