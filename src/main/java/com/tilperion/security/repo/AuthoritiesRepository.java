package com.tilperion.security.repo;

import com.tilperion.security.model.Authority;
import com.tilperion.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authority, Long> {
    // Additional custom query methods can be defined here
}