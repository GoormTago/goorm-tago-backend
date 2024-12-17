package com.example.jpa.repository;

import com.example.entity.JoinData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinDataRepository extends JpaRepository<JoinData, Long> {
}
