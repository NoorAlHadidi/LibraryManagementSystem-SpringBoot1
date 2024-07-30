package com.brightskies.librarysystem1.Controller;

import com.brightskies.librarysystem1.DTO.BookDTO;
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
        if (bookService.findBook(book.getTitle()).isEmpty()) {
            bookService.addBook(book);
            if (authorService.findAuthor(book.getAuthor().getFirst(), book.getAuthor().getLast()).isEmpty()) {
                authorService.addAuthor(book.getAuthor());
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @DeleteMapping("/remove/{title}")
    public ResponseEntity<Void> removeBook(@PathVariable String title) {
        if (bookService.findBook(title).isPresent()) {
            bookService.removeBook(bookService.findBook(title).get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/display")
    public ResponseEntity<ArrayList<BookDTO>> displayBooks() {
        return ResponseEntity.ok(bookService.displayBooks());
    }

    @GetMapping("/retrieve/{first}/{last}")
    public ResponseEntity<ArrayList<BookDTO>> retrieveBooks(@PathVariable String first, @PathVariable String last) {
        if(authorService.findAuthor(first, last).isPresent()) {
            return ResponseEntity.ok(bookService.retrieveBooks(authorService.findAuthor(first, last).get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
