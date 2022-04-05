package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book") // http://localhost:8080/book
public class BookController {

    public final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook (@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{isbn}")
    public Book getById(@PathVariable String isbn){
        return bookService.getBookById(isbn);
    }

    @DeleteMapping(path = "{isbn}")
    public Book deleteBook(@PathVariable String isbn) {
        return bookService.deleteBook(isbn);}
}
