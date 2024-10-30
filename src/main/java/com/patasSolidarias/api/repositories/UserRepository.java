package com.patasSolidarias.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.patasSolidarias.api.models.User;

public interface UserRepository extends MongoRepository<User, String>  {
	 Optional<User> findByEmail(String email); // Método para buscar usuário por email

}
