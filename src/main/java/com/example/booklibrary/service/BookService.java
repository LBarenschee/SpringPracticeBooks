package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepo = new BookRepository();

    public Book addBook(Book book) {
        return bookRepo.addBook(book);
    }

    public List<Book> getAllBooks(){
        return bookRepo.getAllBooks();
    }

    public Book getBookById(String isbn) {
        return bookRepo.getBookById(isbn);
    }

    public Book deleteBook(String isbn) {
        return bookRepo.deleteBook(isbn);
    }
}
