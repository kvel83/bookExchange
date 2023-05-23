package com.example.bookExchange.service;

import com.example.bookExchange.entity.Book;
import com.example.bookExchange.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class BookServiceTest {
    @Autowired
    private BookRepository repository;

    @Test
    void getAllBooks() {
        repository.findAll();
    }

    @Test
    void getBook() {
        Long id = 1L;
        repository.findById(id);
    }

    @Test
    void saveBook() {
        Book book = new Book((long) 1L,"tituloPrueba","1223123123","editorialPrueba","autorPrueba",100, "terror", "");
        repository.save(book);
    }

    @Test
    void deleteBook() {
        Long id = 1L;
        repository.deleteById(id);
    }

    @Test
    void updateBook() {
    }
}