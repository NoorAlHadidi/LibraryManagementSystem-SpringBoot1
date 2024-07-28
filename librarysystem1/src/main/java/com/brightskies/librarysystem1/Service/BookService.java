package com.brightskies.librarysystem1.Service;

import com.brightskies.librarysystem1.Interface.BookInterface;
import com.brightskies.librarysystem1.Model.Author;
import com.brightskies.librarysystem1.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookService implements BookInterface {
    private ArrayList<Book> books;

    @Autowired
    public BookService(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public Optional<Book> findBook(String id) {
        Book result = null;
        for (Book tempBook : books) {
            if ((tempBook.getID()).equals(id)) {
                result = tempBook;
                break;
            }
        }
        return Optional.ofNullable(result);
    }

    @Override
    public void addBook(Book newBook) {
        books.add(newBook);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public ArrayList<Book> displayBooks() {
        return books;
    }

    @Override
    public ArrayList<Book> retrieveBook(Author author) {
        return author.getWritten();
    }
}
