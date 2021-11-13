package com.wiktor.WebApp;

import com.wiktor.WebApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String username);

}