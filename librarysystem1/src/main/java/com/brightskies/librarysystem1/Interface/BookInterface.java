package com.brightskies.librarysystem1.Interface;

import com.brightskies.librarysystem1.Model.*;

import java.util.ArrayList;
import java.util.Optional;

public interface BookInterface {
    public Optional<Book> findBook(String id);
    public void addBook(Book book);
    public void removeBook(Book book);
    public ArrayList<Book> displayBooks();
    public ArrayList<Book> retrieveBook(Author author);
}
