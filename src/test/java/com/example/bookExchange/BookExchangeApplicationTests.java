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

import static org.junit.jupiter.api.Assertions.*;

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

	//Test para método que trae todos los libros
	@Test
	public void testGetAllBooks(){
		List<Book> books = restTemplate.getForObject(baseURL, List.class);
		assertEquals(4, books.size());

	}

	//Test para método que trae un libro por id
	@Test
	public void testGetBook(){
		int id = 12;//Colocar un id existente en la base de datos
		baseURL = baseURL.concat("/" + id);
		Book book = restTemplate.getForObject(baseURL, Book.class);
		assertAll(
				() -> assertNotNull(book),
				() -> assertEquals(12, book.getBookId()),
				() -> assertEquals("Las 2 torres", book.getBookTitle())

		);
	}

	//Test para actualizacion de libro
	@Test
	public void testUpdateBook(){
		int id = 7;//Colocar un id existente en la BBDD
		baseURL = baseURL.concat("/update/" + id);
		Book book = new Book("Harry Potter y el prisionero de Azkaban", "1234567890", "Antártica", "JK. Rowling", 250, "Fantasia", "");
		restTemplate.put(baseURL, book, 7);
		Book bookFromDB = repository.findById(7L).get();
		assertAll(
				() -> assertNotNull(bookFromDB),
				() -> assertEquals("Harry Potter y el prisionero de Azkaban", bookFromDB.getBookTitle())
		);
	}

	//Test para eliminacion de un libro
	@Test
	public void testDeleteBook(){
		int id = 8;//Colocar un ID existente en la BBDD
		int recordSize = repository.findAll().size();//Cantidad de registros en la BBDD
		assertEquals(3, recordSize );
		baseURL = baseURL.concat("/delete/" + id);
		restTemplate.delete(baseURL);
		assertEquals(2, recordSize - 1);
	}
	//Test para guardar un libro
	@Test
	public void testSaveBook(){
		Book book = new Book("Harry Potter", "12367800", "Antártica", "JK. Rowling", 250, "Fantasia", "");
		Book response = restTemplate.postForObject(baseURL, book, Book.class);
		//assertEquals("Harry Potter", response.getBookTitle());
		assertEquals(4, repository.findAll().size());
	}
}
