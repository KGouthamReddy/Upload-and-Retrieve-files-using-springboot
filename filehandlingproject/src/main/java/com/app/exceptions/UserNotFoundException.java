package com.app.exceptions;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
		super("Invalid username or password");
	}
}
