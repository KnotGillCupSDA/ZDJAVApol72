package com.sda.testingadvanced.mockito.databasestore;

import java.util.ArrayList;
import java.util.List;

public class DatabaseStore {

	private final List<String> dbData = new ArrayList<>(); // fake database

	private final DatabaseConnection databaseConnection;

	public DatabaseStore(final DatabaseConnection databaseConnection) {
		this.databaseConnection = databaseConnection;
	}

	public int addData(final String data) {
		if (!databaseConnection.isOpened()) {
			databaseConnection.open();
			if (!databaseConnection.isOpened()) {
				throw new SdaException("Unable to open connection to the database");
			}
		}
		dbData.add(data);
		return dbData.size();
	}
}