package com.nagarro.training.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.model.User;

public interface UserRepo extends JpaRepository<User, String> {


	Optional<User> findByusername(String username);

}