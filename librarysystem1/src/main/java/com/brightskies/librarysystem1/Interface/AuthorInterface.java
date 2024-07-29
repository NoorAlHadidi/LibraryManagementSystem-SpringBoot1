package com.brightskies.librarysystem1.Interface;

import com.brightskies.librarysystem1.Model.Author;
import com.brightskies.librarysystem1.Model.Book;

import java.util.Optional;

public interface AuthorInterface {
    public Optional<Author> findAuthor(String fName, String lName);
    public void addAuthor(Author author);
    public void removeAuthor(Author author);}
