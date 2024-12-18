package io.goormtago.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.goormtago.entity.JoinData;

@Repository
public interface JoinDataRepository extends JpaRepository<JoinData, Long> {
}
