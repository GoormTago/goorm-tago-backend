package io.qook.jweb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.qook.jweb.entity.User;
import io.qook.jweb.jpa.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 리스트 표시
    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index"; // index.html 템플릿 반환
    }

    // 사용자 추가 폼 처리
    @PostMapping("/add-user")
    public String addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(email);        userRepository.save(user);
        return "redirect:/users"; // 사용자 리스트로 리다이렉트
    }

    // JSON 데이터로 사용자 생성
    @PostMapping
    @ResponseBody // JSON 응답으로 반환
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 사용자 수정 메서드
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userRepository.findById(id)
            .map(user -> {
                // 기존 데이터 업데이트
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword()); // 필요한 경우 암호화 처리
                userRepository.save(user);
                return ResponseEntity.ok("User updated successfully!");
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // 사용자 삭제 메서드
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
