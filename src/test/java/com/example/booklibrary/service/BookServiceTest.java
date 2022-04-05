package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    BookRepository bookRepo = mock(BookRepository.class);
    BookService bookService = new BookService(bookRepo);

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
        assertEquals(expected, actual);

    }

    @Test
    void getAllBooks() {
        //Given
        when(bookRepo.getAllBooks()).thenReturn(List.of(book1, book2));

        //when
        List actual = bookService.getAllBooks();


        //then
        List expected = List.of(book1, book2);

        assertEquals(expected, actual);
        verify(bookRepo).getAllBooks();
    }

    @Test
    void getBookById() {
        //Given
        when(bookRepo.getBookById("1234")).thenReturn(book1);

        //When
        Book actual = bookService.getBookById("1234");

        //Then
        Book expected = book1;
        verify(bookRepo).getBookById("1234");
        assertEquals(expected, actual);
    }

    @Test
    void deleteBook() {
        //Given
        when(bookRepo.deleteBook("1234")).thenReturn(new Book("1234", "Deleted book"));

        //When
        Book actual = bookService.deleteBook("1234");

        //Then
        Book expected = new Book("1234", "Deleted book");
        assertEquals(expected, actual);


    }
}