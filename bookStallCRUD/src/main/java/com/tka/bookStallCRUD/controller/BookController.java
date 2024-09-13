package com.tka.bookStallCRUD.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.bookStallCRUD.entity.Book;
import com.tka.bookStallCRUD.service.BookService;

@RestController
@RequestMapping("/api/book")

public class BookController {

	@Autowired
	BookService service;
	
	
	@PostMapping("/addbook")
	public void addBook(@RequestBody Book bookDetails) {
		
		service.addBook(bookDetails);
	}

	
	@GetMapping("/getbook/{id}")
	public Object getbook(@PathVariable int id) {
		
	return service.getbook(id);
	
	}
	
	@GetMapping("/ByAuthorName/{AuthorName}")
	public Object getByAuthorname(@PathVariable String AuthorName) {
		return service.getByAuthorname(AuthorName);
	}
	
	@GetMapping("/getAll") //exception
	public Object getAllbooks() {
		return service.getAll();
	}
	
	@GetMapping("/getBycategory/{category}")
	public List<Book> getbookCategory(@PathVariable String category) {
		
		return service.getbookCategory(category);
	}
	
	
	@PutMapping("/updatebook/{id}")
	public String updatebook(@PathVariable int id, @RequestBody Book bookDetails) {
		Book temp = (Book) service.getbook(id);
		if(temp != null) {
			temp.setBookId(bookDetails.getBookId());
			temp.setBookAuthor(bookDetails.getBookAuthor());
			temp.setBookCategory(bookDetails.getBookCategory());
			temp.setBookTittle(bookDetails.getBookTittle());
			temp.setBookAuthor(bookDetails.getBookAuthor());
		}
		
		return service.updatebook(temp);
	}
	
	
	@DeleteMapping("/deletebook/{bookId}")

	public String deleteByid(@PathVariable int bookId) {
		
		Book deleteObj = (Book) service.getbook(bookId);
		System.out.println(deleteObj);
		
		if(deleteObj !=  null) {
			return service.deleteByid(deleteObj);
		}
		return null;
	}
	

	
}
