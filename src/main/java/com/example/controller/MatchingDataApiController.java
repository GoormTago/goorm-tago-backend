package com.example.api;

import com.example.entity.MatchingData;
import com.example.jpa.repository.MatchingDataRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matching-data")
@Tag(name = "MatchingData API", description = "APIs for managing matching data")
public class MatchingDataApiController {

    @Autowired
    private MatchingDataRepository matchingDataRepository;

    @GetMapping
    @Operation(summary = "Get all matching data", description = "Retrieve a list of all matching data records")
    public List<MatchingData> getAllMatchingData() {
        return matchingDataRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get matching data by ID", description = "Retrieve a matching data record by its ID")
    public ResponseEntity<MatchingData> getMatchingDataById(@PathVariable Long id) {
        Optional<MatchingData> matchingData = matchingDataRepository.findById(id);
        return matchingData.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Add a new matching data", description = "Create a new matching data record")
    public MatchingData addMatchingData(@RequestBody MatchingData matchingData) {
        return matchingDataRepository.save(matchingData);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update matching data", description = "Update an existing matching data record by its ID")
    public ResponseEntity<MatchingData> updateMatchingData(@PathVariable Long id, @RequestBody MatchingData matchingData) {
        if (!matchingDataRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        matchingData.setId(id);
        return ResponseEntity.ok(matchingDataRepository.save(matchingData));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete matching data", description = "Delete a matching data record by its ID")
    public ResponseEntity<Void> deleteMatchingData(@PathVariable Long id) {
        if (!matchingDataRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        matchingDataRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
