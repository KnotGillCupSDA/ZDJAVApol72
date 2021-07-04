package com.sda.testingadvanced.mockito.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Optional;

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
}
