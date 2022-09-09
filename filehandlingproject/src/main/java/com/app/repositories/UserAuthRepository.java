package com.app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.UserAuth;

public interface UserAuthRepository extends CrudRepository<UserAuth, Integer>{

	Optional<UserAuth> findUserByUsername(String username);

}
