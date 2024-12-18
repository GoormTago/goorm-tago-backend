package io.goormtago.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.goormtago.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}