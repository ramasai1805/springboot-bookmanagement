package com.sai.BookCrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.BookCrud.dto.BookRequestDto;
import com.sai.BookCrud.model.Book;
import com.sai.BookCrud.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping(value = "/saveBook")
	public ResponseEntity<String> saveBookRecords(@RequestBody BookRequestDto bookRequestDto) {
		if (bookRequestDto != null) {
			System.out.println("Book Object " + bookRequestDto);
			bookService.saveBook(bookRequestDto);
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAILURE", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping(value = "/updateBook")
	public ResponseEntity<String> updateBookRecords(@RequestBody BookRequestDto bookRequestDto) {
		if (bookRequestDto != null) {
			bookService.updateBook(bookRequestDto);
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAILURE", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping(value = "/delete/{bookId}")
	public ResponseEntity<String> removeBookRecords(@PathVariable(value = "bookId") String bookId) {
		if (bookId != null) {
			bookService.deleteBook(Long.valueOf(bookId));
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAILURE", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/getbook/{bookId}")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable(value = "bookId") String bookId) {
		if (bookId != null) {
			Optional<Book> bo = bookService.getBookById(Long.parseLong(bookId));
			return new ResponseEntity<Optional<Book>>(bo, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping(value = "/updateByName")
	public ResponseEntity<String> updateBookByNameAndBookId(@RequestBody BookRequestDto bookRequestDto) {
		if (bookRequestDto != null) {
			bookService.updatebookByAuthor(bookRequestDto.getBookName(), bookRequestDto.getBookId());
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAILURE", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/getAllBook")
	public ResponseEntity<List<BookRequestDto>> getallBookRecords() {
		return new ResponseEntity<List<BookRequestDto>>(bookService.getAllBook(), HttpStatus.OK);
	}

}

/*
 * savebook alternative try { if (bookRequestDto != null) {
 * bookService.saveBook(bookRequestDto); return new
 * ResponseEntity<String>("SUCCESS", HttpStatus.OK); } } catch (Exception e) {
 * return new ResponseEntity<>(e.getMessage(),
 * HttpStatus.INTERNAL_SERVER_ERROR); } return new
 * ResponseEntity<String>("FAILURE", HttpStatus.INTERNAL_SERVER_ERROR);
 */