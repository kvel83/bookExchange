package com.example.bookExchange.entity;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import lombok.Data;
>>>>>>> 37934392346a94cb0f63f726860ce8526bd03a31

import javax.persistence.*;

@Data
<<<<<<< HEAD
=======
>>>>>>> 37934392346a94cb0f63f726860ce8526bd03a31
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
