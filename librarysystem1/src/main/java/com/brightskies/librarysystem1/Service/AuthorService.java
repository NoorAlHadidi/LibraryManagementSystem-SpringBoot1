package com.brightskies.librarysystem1.Service;

import com.brightskies.librarysystem1.Interface.AuthorInterface;
import com.brightskies.librarysystem1.Model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthorService implements AuthorInterface {
    private ArrayList<Author> authors;

    @Autowired
    public AuthorService(ArrayList<Author> authors) {
        this.authors = authors;
    }

    @Override
    public Optional<Author> findAuthor(String fName, String lName) {
        Author result = null;
        for (Author tempAuthor : authors) {
            if ((tempAuthor.getFirst()).equals(fName) && (tempAuthor.getLast()).equals(lName)) {
                result = tempAuthor;
                break;
            }
        }
        return Optional.ofNullable(result);
    }

    @Override
    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public void removeAuthor(Author author) {
        authors.remove(author);
    }
}
