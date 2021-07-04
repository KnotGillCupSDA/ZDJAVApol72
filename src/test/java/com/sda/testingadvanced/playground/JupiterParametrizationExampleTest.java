package com.sda.testingadvanced.playground;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class JupiterParametrizationExampleTest {

	/*
	 *	ValueSource
	 */
	@ParameterizedTest(name = "Passing double value: {arguments}")
	@ValueSource(doubles = { 1, 2.3, 4.1, 5.5 })
	void shouldPassDoubleToParam(double param) {
		System.out.println("passed value: "+ param);
	}

	@ParameterizedTest(name = "run #{index} with [{arguments}]")
	@ValueSource(strings = { "Ala", "ma", "kota", "." })
	void shouldPassStringToTest(String word) {
		System.out.println("passed word: "+ word);
	}

	@ParameterizedTest
	@ValueSource(classes = { String.class, Integer.class, Double.class })
	void shouldPassClassTypeAsParam(Class<?> clazz) {
		System.out.println("passed class: "+ clazz.getSimpleName());
	}

	@ParameterizedTest
	@ValueSource(strings = { "Testing", "JUnit", "SDA" })
	void valueSourceTest(String word) {
		System.out.println("Passed word: " + word);
		assertNotNull(word);
	}

	/*
	 *	EnumSource
	 */
	enum TemperatureConverter {
		CELSIUS_KELVIN(cTemp -> cTemp + 273.15f),
		KELVIN_CELSIUS(kTemp -> kTemp - 273.15f),
		CELSIUS_FAHRENHEIT(cTemp -> cTemp * 9 / 5f + 32);

		private Function<Float, Float> converter;

		TemperatureConverter(Function<Float, Float> converter) {
			this.converter = converter;
		}

		public float convertTemp(float temp) {
			return converter.apply(temp);
		}
	}

	@ParameterizedTest
	@EnumSource(TemperatureConverter.class)
	void shouldConvertToValueHigherThanMinInteger(TemperatureConverter converter) {
		assertTrue(converter.convertTemp(10) > Integer.MIN_VALUE);
	}

	@ParameterizedTest
	@EnumSource(value = TemperatureConverter.class, names = { "CELSIUS_KELVIN", "CELSIUS_FAHRENHEIT" })
	void shouldConvertToTemperatureLowerThanMaxInteger(TemperatureConverter converter) {
		assertTrue(converter.convertTemp(10) < Integer.MAX_VALUE);
	}

	@ParameterizedTest
	@EnumSource(value = TemperatureConverter.class,
			names = { "KELVIN_CELSIUS" },
			mode = EnumSource.Mode.EXCLUDE)
	void shouldConvertTemperatureToPositiveValue(TemperatureConverter converter) {
		assertTrue(converter.convertTemp(10) > 0); // test zostanie uruchomiony dla wartości CELSIUS_KELVIN i CELSIUS_FAHRENHEIT
	}

	/*
	 * CsvSource
	 */
	private static class Strings {

		private static String toUpperCase(String input) {
			return input.trim().toUpperCase();
		}

		private static boolean isBlank(String input) {
			return input == null || input.trim().isEmpty();
		}
	}

	@ParameterizedTest
	@CsvSource({ "  test  ,TEST", "tEst ,TEST", "   Java,JAVA" })
	void shouldTrimAndUppercaseInput(String input, String expected) {
		String actualValue = Strings.toUpperCase(input);
		assertEquals(expected, actualValue);
	}

	@ParameterizedTest
	@CsvSource({ "1, 2, 3", "3, 4, 7", "-3, -1, -4" })
	void csvSourceTest(int a, int b, int sum) {
		assertEquals(sum, a + b);
	}

	/*
	 * CvsFileSource
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	// plik data.csv musi znaleźć się w roocie classpath, pomijamy pierwszą linię w pliku
	void shouldUppercaseAndBeEqualToExpected(String input, String expected) {
		String actualValue = Strings.toUpperCase(input);
		assertEquals(expected, actualValue);
	}

	/*
	 * MethodSource
	 */

	@ParameterizedTest
	@MethodSource("provideNumbers")
	void shouldBeOdd(final Integer number) {
		assertThat(number % 2).isEqualTo(1);
	}

	static Stream<Integer> provideNumbers() {
		return Stream.of(1, 13, 101, 11, 121);
	}

	@ParameterizedTest
	@MethodSource("provideNumbersWithInfoAboutParity")
	void shouldTestOddOrEven(int number, boolean expected) {
		assertEquals(expected, number % 2 == 1);
	}

	private static Stream<Arguments> provideNumbersWithInfoAboutParity() {
		return Stream.of(Arguments.of(1, true),
				Arguments.of(2, false),
				Arguments.of(10, false),
				Arguments.of(11, true));
	}

	/*
	 * Combined
	 */
	@ParameterizedTest
	@CsvSource(value = "1, true")
	@MethodSource("provideNumbersWithInfoAboutParity")
	void shouldTestOddOrEvenCombined(int number, boolean expected) {
		assertEquals(expected, number % 2 == 1);
	}

	/*
	 * HelperSources
	 */
	private static class Arrays {

		private static boolean isValid(List<String> values) {
			return values != null && !values.isEmpty();
		}
	}

	@ParameterizedTest
	@EmptySource
	void shouldNotBeValid(List<String> input) {
		assertFalse(Arrays.isValid(input));
	}

	@ParameterizedTest
	@NullAndEmptySource
	void nullAndEmptyShouldBeBlank(String input) {
		assertTrue(Strings.isBlank(input));
	}
}
