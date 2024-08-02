package com.jpaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaexample.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
