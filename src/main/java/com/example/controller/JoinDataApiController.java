package com.example.controller;

import com.example.entity.JoinData;
import com.example.jpa.repository.JoinDataRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/join-data")
@Tag(name = "JoinData API", description = "APIs for managing join data")
public class JoinDataApiController {

    @Autowired
    private JoinDataRepository joinDataRepository;

    @GetMapping
    @Operation(summary = "Get all join data", description = "Retrieve a list of all join data records")
    public List<JoinData> getAllJoinData() {
        return joinDataRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get join data by ID", description = "Retrieve a join data record by its ID")
    public ResponseEntity<JoinData> getJoinDataById(@PathVariable Long id) {
        Optional<JoinData> joinData = joinDataRepository.findById(id);
        return joinData.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Add a new join data", description = "Create a new join data record")
    public JoinData addJoinData(@RequestBody JoinData joinData) {
        return joinDataRepository.save(joinData);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update join data", description = "Update an existing join data record by its ID")
    public ResponseEntity<JoinData> updateJoinData(@PathVariable Long id, @RequestBody JoinData joinData) {
        if (!joinDataRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        joinData.setId(id);
        return ResponseEntity.ok(joinDataRepository.save(joinData));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete join data", description = "Delete a join data record by its ID")
    public ResponseEntity<Void> deleteJoinData(@PathVariable Long id) {
        if (!joinDataRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        joinDataRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
