package com.sda.testingadvanced.parameters;

public class PalindromeChecker {

	public static boolean isPalindrome(String word) {
		return new StringBuilder(word).reverse().toString().equals(word);
	}
}
