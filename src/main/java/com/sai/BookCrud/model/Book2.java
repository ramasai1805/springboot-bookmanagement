package com.sai.BookCrud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK2")
public class Book2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Book_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	@Column(name = "BookName")
	private String bookName;
	@Column(name = "Author_Name")
	private String authorName;
	@Column(name = "Book_Price")
	private Double bookPrice;

	public Book2() {
		System.out.println("Book Constructor");
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", bookPrice="
				+ bookPrice + "]";
	}

}