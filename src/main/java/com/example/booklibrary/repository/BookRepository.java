package com.example.booklibrary.repository;

import com.example.booklibrary.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BookRepository {

    Map<String, Book> bookMap = new HashMap<>();

    @Autowired
    public BookRepository(){}

    public Book addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
        return book;
    }

    public List<Book> getAllBooks(){
        return List.copyOf(bookMap.values());
    }

    public Book getBookById(String isbn) {
        return bookMap.get(isbn);
    }

    public Book deleteBook(String isbn) {
        return bookMap.remove(isbn);
    }
}
