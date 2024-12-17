package com.example.jpa.repository;

import com.example.entity.TaxiReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiReservationRepository extends JpaRepository<TaxiReservation, Long> {
}
