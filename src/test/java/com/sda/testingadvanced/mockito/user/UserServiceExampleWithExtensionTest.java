package com.sda.testingadvanced.mockito.user;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
	void shouldFindUser() {
		Mockito
				.when(userRepository.findById(4L))
				.thenReturn(
						Optional.of(new User(4L, "Tomasz", "Wozniak")));

		Mockito.lenient().when(userRepository.findById(5L)).thenReturn(Optional.empty());

		final User userById = userService.getUserById(4L);

		System.out.println(userById);
		assertNotNull(userById);

		Mockito.verify(userRepository, Mockito.times(1)).findById(4L);
		Mockito.verifyNoInteractions(userValidator);
	}
}
