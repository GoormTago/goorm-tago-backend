package com.example.api;

import com.example.entity.Bookmark;
import com.example.jpa.repository.BookmarkRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookmarks")
@Tag(name = "Bookmark API", description = "APIs for managing bookmarks")
public class BookmarkApiController {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @GetMapping
    @Operation(summary = "Get all bookmarks", description = "Retrieve a list of all bookmarks")
    public List<Bookmark> getAllBookmarks() {
        return bookmarkRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get bookmark by ID", description = "Retrieve a single bookmark by its ID")
    public ResponseEntity<Bookmark> getBookmarkById(@PathVariable Long id) {
        Optional<Bookmark> bookmark = bookmarkRepository.findById(id);
        return bookmark.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Add a new bookmark", description = "Create a new bookmark and save it to the database")
    public Bookmark addBookmark(@RequestBody Bookmark bookmark) {
        return bookmarkRepository.save(bookmark);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a bookmark", description = "Update an existing bookmark by its ID")
    public ResponseEntity<Bookmark> updateBookmark(@PathVariable Long id, @RequestBody Bookmark bookmark) {
        if (!bookmarkRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bookmark.setId(id);
        return ResponseEntity.ok(bookmarkRepository.save(bookmark));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a bookmark", description = "Delete a bookmark by its ID")
    public ResponseEntity<Void> deleteBookmark(@PathVariable Long id) {
        if (!bookmarkRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bookmarkRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
