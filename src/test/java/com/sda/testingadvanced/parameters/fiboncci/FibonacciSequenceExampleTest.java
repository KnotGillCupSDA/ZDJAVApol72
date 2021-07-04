package com.sda.testingadvanced.parameters.fiboncci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class FibonacciSequenceExampleTest {

	@ParameterizedTest
	@MethodSource("provideImplementations")
	void shouldCalculateFibonacciNthElement(FibonacciSequence fibonacciSequence) {
		assertEquals(BigInteger.ZERO, fibonacciSequence.getFibonacciNumber(0));
		assertEquals(BigInteger.ONE, fibonacciSequence.getFibonacciNumber(1));
		assertEquals(BigInteger.ONE, fibonacciSequence.getFibonacciNumber(2));

		assertEquals(new BigInteger("701408733"),
				fibonacciSequence.getFibonacciNumber(44));
	}

	private static Stream<FibonacciSequence> provideImplementations() {
		return Stream.of(new FibonacciSequenceRecursive(), new FibonacciSequenceIterative());
	}
}