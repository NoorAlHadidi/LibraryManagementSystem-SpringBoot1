package com.brightskies.librarysystem1.Interface;

import com.brightskies.librarysystem1.DTO.AuthorDTO;
import com.brightskies.librarysystem1.Model.Author;

import java.util.ArrayList;
import java.util.Optional;

public interface AuthorInterface {
    public ArrayList<AuthorDTO> displayAuthors();
    public Optional<Author> findAuthor(String fName, String lName);
    public void addAuthor(Author author);
    public void removeAuthor(Author author);}
