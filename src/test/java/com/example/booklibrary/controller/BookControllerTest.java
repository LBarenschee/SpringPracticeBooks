package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void cleanUp() {
        bookRepository.deleteAll();
    }

    @Test
    void addBook() {
        //Given
        Book book = new Book("1234", "test-title");

        //When
        Book actual = webTestClient
                .post()
                .uri("http://localhost:" + port + "/book")
                .bodyValue(book)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();

        //Then
        Book expected = new Book("1234", "test-title");
        assertEquals(expected, actual);

    }

    @Test
    void getAllBooks() {
        //Given
        Book book = new Book("1234", "test-title");
        bookRepository.addBook(book);

        //When
        List<Book> actual = webTestClient
                .get()
                .uri( "/book")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(Book.class)
                .returnResult()
                .getResponseBody();

        //Then
        List<Book> expected = List.of(new Book("1234", "test-title"));
        assertEquals(expected,actual);
    }

    @Test
    void getById() {
        //Given
        Book book = new Book("1234", "test-title");
        bookRepository.addBook(book);

        //When
        Book actual = webTestClient
                .get()
                .uri("http://localhost:" + port + "/book"+"/1234")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();

        //Then
        Book expected = new Book("1234", "test-title");
        assertEquals(expected, actual);
    }

    @Test
    void deleteBook() {
        //Given
        Book book1 = new Book("1234", "test-title");
        Book book2 = new Book("5678", "test-title2");
        bookRepository.addBook(book1);
        //bookRepository.addBook(book2);

        //When
        Book actual = webTestClient
                .delete()
                .uri("http://localhost:" + port + "/book/1234")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();

        //Then
        Book expected = new Book("1234", "test-title");
        assertEquals(expected, actual);

  /*      Book test = webTestClient
                .get()
                .uri("http://localhost:" + port + "/book"+"/1234")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();

        assertEquals(expected,test);*/
    }
}