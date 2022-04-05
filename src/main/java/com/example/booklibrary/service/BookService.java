package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepo = new BookRepository();

    public Book addBook(Book book) {
        return bookRepo.addBook(book);
    }
}
