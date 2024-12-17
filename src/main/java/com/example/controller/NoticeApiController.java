package com.example.api;

import com.example.entity.Notice;
import com.example.jpa.repository.NoticeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notices")
@Tag(name = "Notice API", description = "APIs for managing notices")
public class NoticeApiController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping
    @Operation(summary = "Get all notices", description = "Retrieve a list of all notices")
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get notice by ID", description = "Retrieve a notice by its ID")
    public ResponseEntity<Notice> getNoticeById(@PathVariable Long id) {
        Optional<Notice> notice = noticeRepository.findById(id);
        return notice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Add a new notice", description = "Create a new notice")
    public Notice addNotice(@RequestBody Notice notice) {
        return noticeRepository.save(notice);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a notice", description = "Update an existing notice by its ID")
    public ResponseEntity<Notice> updateNotice(@PathVariable Long id, @RequestBody Notice notice) {
        if (!noticeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        notice.setId(id);
        return ResponseEntity.ok(noticeRepository.save(notice));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a notice", description = "Delete a notice by its ID")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id) {
        if (!noticeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        noticeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
