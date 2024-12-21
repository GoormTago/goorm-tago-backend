package io.goormtago.controller.view;

import io.goormtago.entity.User;
import io.goormtago.jpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/view/users")
public class UserVIewController {

    @Autowired
    private UserRepository userRepository;

    // 사용자 목록 조회
    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user-list";
    }

    // 사용자 추가 처리
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> addUser(@ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        userRepository.save(user);
        return ResponseEntity.ok("사용자가 성공적으로 추가되었습니다.");
    }

 // 사용자 수정 처리
    @PostMapping("/edit/{id}")
    @ResponseBody
    public ResponseEntity<?> updateUser(@PathVariable Long id, @ModelAttribute User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        user.setId(id);
        userRepository.save(user);
        return ResponseEntity.ok("사용자가 성공적으로 수정되었습니다.");
    }

    // 사용자 삭제
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/api/view/users";
    }
}
