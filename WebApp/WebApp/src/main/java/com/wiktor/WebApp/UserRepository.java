package com.wiktor.WebApp;

import com.wiktor.WebApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    //Optional<>
    User findByUserName(String username);
}