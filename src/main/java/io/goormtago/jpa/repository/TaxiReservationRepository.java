package io.goormtago.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.goormtago.entity.TaxiReservation;

@Repository
public interface TaxiReservationRepository extends JpaRepository<TaxiReservation, Long> {
}
