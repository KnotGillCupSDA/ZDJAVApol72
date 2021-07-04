package com.sda.testingadvanced.mockito.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceExampleWithExtensionTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserValidator userValidator;

	@InjectMocks
	private UserService userService;

	@Test
	void experiments() {
		when(userRepository.findById(4L))
				.thenReturn(
						Optional.of(new User(4L, "Tomasz", "Wozniak")));

		lenient().when(userRepository.findById(5L)).thenReturn(Optional.empty());

		final User userById = userService.getUserById(4L);

		System.out.println(userById);
		assertNotNull(userById);

		verify(userRepository, times(1)).findById(4L);
		verifyNoInteractions(userValidator);
	}

	@Test
	void shouldFindUserById() {
		//given
		final Long userId = 1L;
		final User user = new User(userId, "MockedName", "MockedLastName");
		when(userRepository.findById(userId)).thenReturn(Optional.of(user));

		//when
		final Optional<User> byId = userRepository.findById(userId);

		//then
		assertFalse(byId.isEmpty());
		assertEquals(user, byId.get());
	}

	@Test
	void shouldAddValidUser() {
		//given
		final User user = new User(7L, "MockedName", "MockedLastName");
		when(userValidator.isUserValid(user)).thenReturn(true);
		when(userRepository.addUser(user)).thenReturn(user);

		//when
		final User addedUser = userService.addUser(user);

		//then
		assertNotNull(addedUser);
		assertEquals(user, addedUser);
	}

	@Test
	void shouldThrowsExceptionForInvalidUser() {
		//given
		final long id = 7L;
		final User user = new User(id, "MockedName", "MockedLastName");
		when(userValidator.isUserValid(user)).thenReturn(false);

		//when, then
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> userService.addUser(user))
				.withMessageContaining(String.valueOf(id));

		Mockito.verifyNoInteractions(userRepository);
	}
}
