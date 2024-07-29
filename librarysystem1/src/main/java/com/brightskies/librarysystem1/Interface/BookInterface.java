package com.brightskies.librarysystem1.Interface;

import com.brightskies.librarysystem1.DTO.BookDTO;
import com.brightskies.librarysystem1.Model.*;

import java.util.ArrayList;
import java.util.Optional;

public interface BookInterface {
    public Optional<Book> findBook(String title);
    public void addBook(Book book);
    public void removeBook(Book book);
    public ArrayList<BookDTO> displayBooks();
    public ArrayList<BookDTO> retrieveBooks(Author author);
}
