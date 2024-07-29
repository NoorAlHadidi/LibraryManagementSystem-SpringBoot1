package com.brightskies.librarysystem1.Controller;

import com.brightskies.librarysystem1.Model.*;
import com.brightskies.librarysystem1.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/api/book")
@RestController
public class BookController {
    private BookService bookService;
    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addBook(@RequestBody Book book) {
        if (bookService.findBook(book.getID()).isEmpty()) {
            bookService.addBook(book);
            if (authorService.findAuthor(book.getAuthor().getFirst(), book.getAuthor().getLast()).isEmpty()) {
                authorService.addAuthor(book.getAuthor());
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeBook(@PathVariable String id) {
        if (bookService.findBook(id).isPresent()) {
            bookService.removeBook(bookService.findBook(id).get());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/display")
    public ResponseEntity<ArrayList<Book>> displayBooks() {
        return ResponseEntity.ok(bookService.displayBooks());
    }

    @GetMapping("/retrieve/{first}/{last}")
    public ResponseEntity<ArrayList<Book>> retrieveBooks(@PathVariable String first, @PathVariable String last) {
        return ResponseEntity.ok(bookService.retrieveBook(authorService.findAuthor(first, last).get()));
    }

}
