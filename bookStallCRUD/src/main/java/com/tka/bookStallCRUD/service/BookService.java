package com.tka.bookStallCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.bookStallCRUD.dao.BookDAO;
import com.tka.bookStallCRUD.entity.Book;

@Service
public class BookService {

	@Autowired
	BookDAO dao;
	String noAuthorFound = "please provide appropriate information..";

	public void addBook(Book bookDetails) {
		dao.addBook(bookDetails);

	}

	public Book getbook(int id) {

		return dao.getbook(id);
	}

	public Object getByAuthorname(String authorName) {

		if (dao.getByAuthorname(authorName) != null) {
			return dao.getByAuthorname(authorName);
		}
		return noAuthorFound;

	}

	public Object getAll() {
		if (dao.getAll() != null) {
			return dao.getAll();
		}
		return noAuthorFound;

	}

	public String updatebook(Book temp) {
		return dao.updatebook(temp);

	}

	public String deleteByid(Book deleteObj) {
		return dao.deleteByid(deleteObj);

	}

	public List<Book> getbookCategory(String category) {
		return dao.getbookCategory(category);
	}

}
