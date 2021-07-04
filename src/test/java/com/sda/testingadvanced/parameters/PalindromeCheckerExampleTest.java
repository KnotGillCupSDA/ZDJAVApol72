package com.sda.testingadvanced.parameters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PalindromeCheckerExampleTest {

	@ParameterizedTest
	@CsvSource({"ala, true", "kajak, true", "costam, false"})
	void shouldCheckWhetherWordIsAPalindrome(String word, boolean expected) {
		assertEquals(expected, PalindromeChecker.isPalindrome(word));
	}

}