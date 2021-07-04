package com.sda.testingadvanced.mockito.user;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceExampleOldschoolTest {

	private UserRepository userRepository;
	private UserValidator userValidator;

	private UserService userService;

	@BeforeEach
	void setUp() {
		userRepository = mock(UserRepository.class);
		userValidator = mock(UserValidator.class);

		userService = new UserService(userRepository, userValidator);
	}

	@Test
	void shouldFindUser() {
	}
}
