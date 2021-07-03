package com.sda.testingadvanced.mockito.user;

import java.util.Optional;

public interface UserRepository {
	Optional<User> findById(Long id);
	User addUser(User user);
}