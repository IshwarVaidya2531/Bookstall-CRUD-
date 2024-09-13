package com.tka.bookStallCRUD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "book_id")
	private int bookId;
	private String bookTittle;
	private String bookCategory;
	private String bookAuthor;
	private String bookPrice;
	
	
	public Book(int bookId, String bookTittle, String bookCategory, String bookAuthor, String bookPrice) {
		super();
		this.bookId = bookId;
		this.bookTittle = bookTittle;
		this.bookCategory = bookCategory;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
	}


	public Book() {
		super();
		
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getBookTittle() {
		return bookTittle;
	}


	public void setBookTittle(String bookTittle) {
		this.bookTittle = bookTittle;
	}


	public String getBookCategory() {
		return bookCategory;
	}


	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public String getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTittle=" + bookTittle + ", bookCategory=" + bookCategory
				+ ", bookAuthor=" + bookAuthor + ", bookPrice=" + bookPrice + "]";
	}
	
	
	
	
}
