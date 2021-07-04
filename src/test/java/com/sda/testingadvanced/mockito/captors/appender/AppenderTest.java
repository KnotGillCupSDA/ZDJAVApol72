package com.sda.testingadvanced.mockito.captors.appender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppenderTest {

	@Mock
	private Receiver receiver;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	void shouldAppendSuffix() {
		//given
		final String message = "aaa";
		final Appender appender = new Appender(receiver, "---");
		doNothing().when(receiver).accept(stringArgumentCaptor.capture());

		//when
		appender.append(message);

		//then
		assertEquals("aaa---", stringArgumentCaptor.getValue());

	}
}