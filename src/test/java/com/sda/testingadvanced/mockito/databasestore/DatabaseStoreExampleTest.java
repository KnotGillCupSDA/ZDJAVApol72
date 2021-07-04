package com.sda.testingadvanced.mockito.databasestore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DatabaseStoreExampleTest {

	@Mock
	private DatabaseConnection databaseConnection;

	@InjectMocks
	private DatabaseStore databaseStore;

	@Test
	void shouldAddDataForOpenedDatabaseConnection() {
		//given
		final String data = "data";
		when(databaseConnection.isOpened()).thenReturn(true);

		//when
		final int dbSize = databaseStore.addData(data);

		//then
		assertEquals(1, dbSize);
		verify(databaseConnection).isOpened();
		verify(databaseConnection, never()).open();

	}

	@Test
	void shouldOpenDatabaseConnectionAndAddData() {
		//given
		final String data = "data";
		when(databaseConnection.isOpened()).thenReturn(false, true);

		//when
		final int dbSize = databaseStore.addData(data);
		//then
		assertEquals(1, dbSize);
		//verify(databaseConnection).isOpened();
		verify(databaseConnection).open();
	}

	@Test
	void shouldThrowExceptionWhenCantOpenDatabaseConnection() {
		//given
		final String data = "data";
		when(databaseConnection.isOpened()).thenReturn(false);

		//when, then
		assertThrows(SdaException.class, () -> databaseStore.addData(data));
	}
}
