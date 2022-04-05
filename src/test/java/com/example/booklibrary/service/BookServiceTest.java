package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    BookRepository bookRepo = mock(BookRepository.class);
    BookService bookService = new BookService();

    Book book1 = new Book("1234", "Bibel");
    Book book2 = new Book("666", "Black Magic");

    @Test
    void addBook() {
        //GIVEN
        when(bookRepo.addBook(book1)).thenReturn(book1);

        //WHEN
        Book actual = bookService.addBook(book1);

        //THEN
        Book expected = book1;

        verify(bookRepo).addBook(new Book("1234", "Bibel"));
        assertEquals(expected,actual);

    }

    @Test
    void getAllBooks() {
    }

    @Test
    void getBookById() {
    }

    @Test
    void deleteBook() {
    }
}