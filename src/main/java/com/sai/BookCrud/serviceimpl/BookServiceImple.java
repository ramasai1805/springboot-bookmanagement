package com.sai.BookCrud.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.BookCrud.dto.BookRequestDto;
import com.sai.BookCrud.model.Book;
import com.sai.BookCrud.repository.BookRepository;
import com.sai.BookCrud.service.BookService;

@Service
public class BookServiceImple implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<BookRequestDto> getAllBook() {
		List<Book> listOfBooks = bookRepository.findAll();
		List<BookRequestDto> listOfDtos = new ArrayList<BookRequestDto>();
		for (Book b : listOfBooks) {
			BookRequestDto book = new BookRequestDto();
			book.setAuthorName(b.getAuthorName());
			book.setBookId(b.getBookId());
			book.setBookName(b.getBookName());
			book.setBookPrice(b.getBookPrice());
			listOfDtos.add(book);
		}
		return listOfDtos;
	}

	@Override
	public void saveBook(BookRequestDto bookRequestDto) {
		Book book = new Book();
		book.setAuthorName(bookRequestDto.getAuthorName());
		book.setBookId(bookRequestDto.getBookId());
		book.setBookName(bookRequestDto.getBookName());
		book.setBookPrice(bookRequestDto.getBookPrice());
		bookRepository.save(book);
	}

	@Override
	public void updateBook(BookRequestDto bookRequestDto) {
		Book book = new Book();
		book.setAuthorName(bookRequestDto.getAuthorName());
		book.setBookId(bookRequestDto.getBookId());
		book.setBookName(bookRequestDto.getBookName());
		book.setBookPrice(bookRequestDto.getBookPrice());
		bookRepository.save(book);

	}

	@Override
	public void deleteBook(Long bookId) {
		if (bookId != null) {
			bookRepository.deleteById(bookId);
		}
	}

	@Override
	public Optional<Book> getBookById(Long bookId) {
		return bookRepository.findById(bookId);
	}

	@Override
	public void updatebookByAuthor(String bookName, Long bookId) {
		bookRepository.updateBookByName(bookName, bookId);
	}

}
