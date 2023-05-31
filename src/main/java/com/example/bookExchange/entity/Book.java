package com.example.bookExchange.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookTitle;
    @Column(name = "isbn", unique = true) // Se agrega restricción de que el campo sea único 29/05/2023 @Katia Velasquez
    private  String bookIsbn;
    private String bookEditorial;
    private String bookAuthor;
    private int bookPages;
    private String bookGenre;
    private String bookLink;

    //Constructor sin campo bookId
    public Book(String bookTitle, String bookIsbn, String bookEditorial, String bookAuthor, int bookPages, String bookGenre, String bookLink) {
        this.bookTitle = bookTitle;
        this.bookIsbn = bookIsbn;
        this.bookEditorial = bookEditorial;
        this.bookAuthor = bookAuthor;
        this.bookPages = bookPages;
        this.bookGenre = bookGenre;
        this.bookLink = bookLink;
    }
}
