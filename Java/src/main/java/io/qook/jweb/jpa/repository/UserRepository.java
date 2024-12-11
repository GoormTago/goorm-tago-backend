package io.qook.jweb.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import io.qook.jweb.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
}
