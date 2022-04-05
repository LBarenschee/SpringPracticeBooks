package com.example.booklibrary.repository;

import com.example.booklibrary.model.Book;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;


@Service
public class BookRepository {

    Map<String, Book> bookMap = new HashMap<>();


    public Book addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
        return book;
    }


}
