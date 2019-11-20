package org.stack.oasis.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.stack.oasis.application.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUserName(String userName);

}
