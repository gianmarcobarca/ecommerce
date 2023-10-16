package com.barca.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.barca.ecommerce.dtos.UserCartDto;
import com.barca.ecommerce.models.User;

public interface UserRepository extends MongoRepository<User, String> {

  Optional<User> findByEmail(String email);

  UserCartDto findFirstById(String id);
}
