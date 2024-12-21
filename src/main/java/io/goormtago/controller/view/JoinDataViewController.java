package io.goormtago.controller.view;

import io.goormtago.entity.JoinData;
import io.goormtago.jpa.repository.JoinDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/api/view/join-data")
public class JoinDataViewController {

    @Autowired
    private JoinDataRepository joinDataRepository;

    // JoinData 리스트를 가져와 뷰에 전달
    @GetMapping
    public String getAllJoinData(Model model) {
        model.addAttribute("joinDataList", joinDataRepository.findAll());
        return "join-data-list";
    }

    // 새로운 JoinData 추가
    @PostMapping("/add")
    public ResponseEntity<String> addJoinData(@ModelAttribute JoinData joinData) {
        joinDataRepository.save(joinData);
        return ResponseEntity.ok("Join Data added successfully!");
    }

    // 기존 JoinData 수정
    @PostMapping("/edit/{id}")
    public ResponseEntity<String> updateJoinData(@PathVariable Long id, @ModelAttribute JoinData joinData) {
        if (joinDataRepository.existsById(id)) {
            joinData.setId(id);
            joinDataRepository.save(joinData);
            return ResponseEntity.ok("Join Data updated successfully!");
        }
        return ResponseEntity.badRequest().body("Join Data not found.");
    }

    // JoinData 삭제
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoinData(@PathVariable Long id) {
        if (joinDataRepository.existsById(id)) {
            joinDataRepository.deleteById(id);
            return ResponseEntity.ok("Join Data deleted successfully!");
        }
        return ResponseEntity.badRequest().body("Join Data not found.");
    }
}
