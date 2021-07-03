package com.sda.testingadvanced.mockito.captors.appender;

import java.util.function.Consumer;

public class Appender {

	private final Consumer<String> receiver;
	private final String suffix;

	public Appender(Receiver receiver, String suffix) {
		this.receiver = receiver;
		this.suffix = suffix;
	}

	public void append(String toAppend) {
		receiver.accept(toAppend + suffix);
	}

}
