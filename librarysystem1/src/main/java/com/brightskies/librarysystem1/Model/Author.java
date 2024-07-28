package com.brightskies.librarysystem1.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Author extends Human {
    private ArrayList<Book> written;

    public Author() {
        super();
    }

    @Autowired
    public Author(String fName, String lName, int age, ArrayList<Book> written) {
        super(fName, lName, age);
        this.written = written;
    }

    @Autowired
    public Author(String fName, String lName, ArrayList<Book> written) {
        super(fName, lName);
        this.written = written;
    }

    public ArrayList<Book> getWritten() {
        return this.written;
    }
}
