package com.example.bookExchange.controller;

import com.example.bookExchange.entity.Book;
import com.example.bookExchange.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/books")
public class bookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Optional<Book> getBookById(@PathVariable("bookId") Long bookId){
        return bookService.getBook(bookId);
    }

    @PostMapping
    public void saveBook(@RequestBody Book book){
        bookService.saveBook(book);
    }

    @PutMapping("/update/{bookId}")
    public void updateBook(@RequestBody Book book, @PathVariable("bookId") Long bookId){
        bookService.updateBook(bookId, book);
    }

    @DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId){
        bookService.deleteBook(bookId);
    }
}
