package com.app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	
}
