package com.brightskies.librarysystem1.Model;

import org.springframework.stereotype.Component;

@Component
public class Author extends Human {

    public Author() {
        super();
    }

    public Author(String fName, String lName, int age) {
        super(fName, lName, age);
    }

    public Author(String fName, String lName) {
        super(fName, lName);
    }

    public boolean sameAs(Author author) {
        return this.getFirst().equals(author.getFirst()) && this.getLast().equals(author.getLast());
    }
}
