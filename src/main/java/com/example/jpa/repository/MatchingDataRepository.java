package com.example.jpa.repository;

import com.example.entity.MatchingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchingDataRepository extends JpaRepository<MatchingData, Long> {
}
