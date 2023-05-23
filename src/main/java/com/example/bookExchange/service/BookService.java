package com.example.bookExchange.service;

import com.example.bookExchange.entity.Book;
import com.example.bookExchange.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(Long id){
        return bookRepository.findById(id);
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public void updateBook(Long id, Book updatedBook){
        Optional<Book> optionalBook = bookRepository.findById(id);
        optionalBook.ifPresent(book -> {
            book.setBookAuthor(updatedBook.getBookAuthor());
            book.setBookEditorial(updatedBook.getBookEditorial());
            book.setBookGenre(updatedBook.getBookGenre());
            book.setBookLink(updatedBook.getBookLink());
            book.setBookIsbn(updatedBook.getBookIsbn());
            book.setBookPages(updatedBook.getBookPages());
            book.setBookTitle(updatedBook.getBookTitle());
            bookRepository.save(book);
        });

        }
    }

