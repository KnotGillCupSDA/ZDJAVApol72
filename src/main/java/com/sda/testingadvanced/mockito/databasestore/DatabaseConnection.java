package com.sda.testingadvanced.mockito.databasestore;

public interface DatabaseConnection {

	boolean isOpened();

	void open();

	boolean close();
}