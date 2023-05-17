package com.tilperion.security.repo;

import com.tilperion.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom query methods can be defined here
    Optional<User> findByUsername(String username);
}