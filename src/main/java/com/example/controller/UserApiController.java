package com.example.controller;

import com.example.entity.User;
import com.example.jpa.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User API", description = "User 관련 REST API")
public class UserApiController {

    @Autowired
    private UserRepository userRepository;

    @Operation(summary = "모든 사용자 조회", description = "데이터베이스에 저장된 모든 사용자를 조회합니다.")
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Operation(summary = "사용자 ID로 조회", description = "특정 ID를 가진 사용자의 정보를 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @Parameter(description = "조회할 사용자의 ID", required = true)
            @PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "새 사용자 추가", description = "새로운 사용자를 데이터베이스에 추가합니다.")
    @PostMapping
    public ResponseEntity<User> createUser(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "추가할 사용자 정보", required = true)
            @RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @Operation(summary = "사용자 수정", description = "기존 사용자의 정보를 수정합니다.")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @Parameter(description = "수정할 사용자의 ID", required = true)
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "수정할 사용자 정보", required = true)
            @RequestBody User user) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @Operation(summary = "사용자 삭제", description = "특정 사용자를 데이터베이스에서 삭제합니다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "삭제할 사용자의 ID", required = true)
            @PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
