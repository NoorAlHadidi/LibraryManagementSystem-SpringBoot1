package com.brightskies.librarysystem1.Service;

import com.brightskies.librarysystem1.DTO.BookDTO;
import com.brightskies.librarysystem1.Interface.BookInterface;
import com.brightskies.librarysystem1.Model.Author;
import com.brightskies.librarysystem1.Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements BookInterface {
    private ArrayList<Book> books;

    public BookService() {
        this.books = new ArrayList<>();
    }

    /*@Autowired
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }*/

    @Override
    public Optional<Book> findBook(String title) {
        Book result = null;
        for (Book tempBook : books) {
            if ((tempBook.getTitle()).equals(title)) {
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
    public ArrayList<BookDTO> displayBooks() {
        return (this.books).stream().map(book -> new BookDTO(book.getTitle(), book.getAuthor().getFirst(), book.getAuthor().getLast(), book.getGenre())).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ArrayList<BookDTO> retrieveBooks(Author author) {
        ArrayList<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().sameAs(author)) {
                authorBooks.add(book);
            }
        }
        return (authorBooks).stream().map(book -> new BookDTO(book.getTitle(), book.getAuthor().getFirst(), book.getAuthor().getLast(), book.getGenre())).collect(Collectors.toCollection(ArrayList::new));
    }
}
