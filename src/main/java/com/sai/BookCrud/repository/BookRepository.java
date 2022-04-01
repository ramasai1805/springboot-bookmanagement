package com.sai.BookCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sai.BookCrud.model.Book;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
	@Modifying
	@Query("update Book b set b.bookName=:bookName where b.bookId=:bookId")
	public void updateBookByName(@Param(value = "bookName") String bookName, @Param(value = "bookId") Long bookId);
}