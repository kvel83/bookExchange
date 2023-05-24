package com.example.bookExchange;

import com.example.bookExchange.entity.Book;
import com.example.bookExchange.repository.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookExchangeApplicationTests {
	@LocalServerPort
	private int port;

	private String baseURL = "http://localhost:";

	private static RestTemplate restTemplate;

	@Autowired
	private BookRepository repository;

	@BeforeAll
	public static void	init(){
		restTemplate = new RestTemplate();
	}
	@BeforeEach
	public void setUp(){
		baseURL = baseURL.concat(port+"/api/books");
	}

	@Test
	public void testGetAllBooks(){
		List<Book> books = restTemplate.getForObject(baseURL, List.class);
		assertEquals(4, books.size());

	}

	@Test
	public void testGetBook(){
		int id = 12;
		baseURL = baseURL.concat("/" + id);
		Book book = restTemplate.getForObject(baseURL, Book.class);
		assertEquals("Las 2 torres", book.getBookTitle());
	}
	/*//Save a new book test
	@Test
	public void testSaveBook(){
		Book book = new Book(1L, "Harry Potter", "1234567890", "Antártica", "JK. Rowling", 250, "Fantasia", "");
		Book response = restTemplate.postForObject(baseURL, book, Book.class);
		assertEquals("Harry Potter", response.getBookTitle());
		assertEquals(1, repository.findAll().size());
	}*/

}
