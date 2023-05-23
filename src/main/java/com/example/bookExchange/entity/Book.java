package com.example.bookExchange.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookTitle;
    @Column(unique = true)
    private  String bookIsbn;
    private String bookEditorial;
    private String bookAuthor;
    private int bookPages;
    private String bookGenre;
    private String bookLink;
}
