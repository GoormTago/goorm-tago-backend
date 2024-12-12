
package io.qook.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.qook.entity.User;
import io.qook.jpa.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "User API", description = "User 관련 REST API 문서")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
	
    @GetMapping
    @Operation(summary = "모든 사용자 조회", description = "DB에 저장된 모든 사용자를 반환합니다.")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "사용자 ID로 조회", description = "ID를 기준으로 특정 사용자를 반환합니다.")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping
    @Operation(summary = "새 사용자 추가", description = "새로운 사용자를 추가합니다.")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    @Operation(summary = "사용자 정보 수정", description = "기존 사용자의 정보를 수정합니다.")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "사용자 삭제", description = "ID를 기준으로 사용자를 삭제합니다.")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
