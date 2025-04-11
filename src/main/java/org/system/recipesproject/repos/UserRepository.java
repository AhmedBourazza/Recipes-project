package org.system.recipesproject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.recipesproject.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
