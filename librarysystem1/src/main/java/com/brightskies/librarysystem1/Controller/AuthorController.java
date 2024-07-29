package com.brightskies.librarysystem1.Controller;

import com.brightskies.librarysystem1.DTO.AuthorDTO;
import com.brightskies.librarysystem1.Model.Author;
import com.brightskies.librarysystem1.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/api/author")
@RestController
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addAuthor(@RequestBody Author author) {
        if (authorService.findAuthor(author.getFirst(), author.getLast()).isEmpty()) {
            authorService.addAuthor(author);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/remove/{first}/{last}")
    public ResponseEntity<Void> removeAuthor(@PathVariable String first, @PathVariable String last) {
        if (authorService.findAuthor(first, last).isPresent()) {
            authorService.removeAuthor(authorService.findAuthor(first, last).get());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/display")
    public ResponseEntity<ArrayList<AuthorDTO>> displayAuthors() {
        return ResponseEntity.ok(authorService.displayAuthors());
    }
}
