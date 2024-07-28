package com.brightskies.librarysystem1.Interface;

import com.brightskies.librarysystem1.Model.Author;

public interface AuthorInterface {
    public Author findAuthor(String fName, String lName);
    public void addAuthor(Author author);
    public void removeAuthor(Author author);
}
