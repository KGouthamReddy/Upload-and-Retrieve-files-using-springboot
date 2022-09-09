package com.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.UserAuth;
import com.app.exceptions.UserNotFoundException;
import com.app.repositories.UserAuthRepository;

@Service
public class AuthenticationUserService {
	@Autowired
	UserAuthRepository authRepo;

	public UserAuth GetUserByName(String name) {
		Optional<UserAuth> userfound = authRepo.findUserByUsername(name);
		if (userfound.isPresent()) {
			return userfound.get();
		} else {
			throw new UserNotFoundException();

		}
	}

	public Boolean isValidPassword(String cmp, String actual) {
		return ((cmp.equals(actual)) ? true : false);
	}

}
