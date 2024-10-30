package com.patasSolidarias.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.patasSolidarias.api.models.Animal;

public interface AnimalRepository extends MongoRepository<Animal, String>  {

}
