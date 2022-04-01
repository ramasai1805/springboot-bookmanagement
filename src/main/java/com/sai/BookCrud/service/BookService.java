package com.sai.BookCrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.sai.BookCrud.dto.BookRequestDto;
import com.sai.BookCrud.model.Book;

public interface BookService {

	public void saveBook(BookRequestDto bookRequestDto);

	public void updateBook(BookRequestDto bookRequestDto);

	public void deleteBook(Long bookId);

	public Optional<Book> getBookById(Long bookId);

	public List<BookRequestDto> getAllBook();

	public void updatebookByAuthor(String bookName, Long bookId);
}
