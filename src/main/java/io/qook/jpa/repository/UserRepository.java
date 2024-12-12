package io.qook.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.qook.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
