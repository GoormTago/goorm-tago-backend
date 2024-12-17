package com.example.api;

import com.example.entity.TaxiReservation;
import com.example.jpa.repository.TaxiReservationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/taxi-reservations")
@Tag(name = "TaxiReservation API", description = "APIs for managing taxi reservations")
public class TaxiReservationApiController {

    @Autowired
    private TaxiReservationRepository taxiReservationRepository;

    @GetMapping
    @Operation(summary = "Get all taxi reservations", description = "Retrieve a list of all taxi reservations")
    public List<TaxiReservation> getAllTaxiReservations() {
        return taxiReservationRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get taxi reservation by ID", description = "Retrieve a single taxi reservation by its ID")
    public ResponseEntity<TaxiReservation> getTaxiReservationById(@PathVariable Long id) {
        Optional<TaxiReservation> taxiReservation = taxiReservationRepository.findById(id);
        return taxiReservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Add a new taxi reservation", description = "Create a new taxi reservation")
    public TaxiReservation addTaxiReservation(@RequestBody TaxiReservation taxiReservation) {
        return taxiReservationRepository.save(taxiReservation);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update taxi reservation", description = "Update an existing taxi reservation by its ID")
    public ResponseEntity<TaxiReservation> updateTaxiReservation(@PathVariable Long id, @RequestBody TaxiReservation taxiReservation) {
        if (!taxiReservationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taxiReservation.setId(id);
        return ResponseEntity.ok(taxiReservationRepository.save(taxiReservation));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete taxi reservation", description = "Delete a taxi reservation by its ID")
    public ResponseEntity<Void> deleteTaxiReservation(@PathVariable Long id) {
        if (!taxiReservationRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taxiReservationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
