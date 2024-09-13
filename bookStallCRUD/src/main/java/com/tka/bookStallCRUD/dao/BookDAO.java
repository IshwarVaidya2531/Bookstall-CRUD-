package com.tka.bookStallCRUD.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.bookStallCRUD.entity.Book;

@Repository
public class BookDAO {

	@Autowired
	SessionFactory factory;
	Session session;
	Transaction transaction;
	Book bookObj;
	List<Book> books;

	String returnmsg = "Transaction successfull..Thank you..!!";

	public void addBook(Book bookDetails) {

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(bookDetails);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				transaction.commit();
				session.close();
			}
		}

	}

	public Book getbook(int id) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			bookObj = session.get(Book.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				transaction.commit();
				session.close();
			}
		}
		return bookObj;

	}

	public Book getByAuthorname(String authorName) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Book.class);
			bookObj = (Book) criteria.add(Restrictions.eq("bookAuthor", authorName)).uniqueResult();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				transaction.commit();
				session.close();
			}
		}
		return bookObj;

	}

	public List<Book> getAll() {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			books = session.createQuery("FROM Book", Book.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				transaction.commit();
				session.close();
			}
		}
		return books;

	}

	public String updatebook(Book temp) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(temp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				transaction.commit();
				session.close();
			}
		}
		return returnmsg;

	}

	
	public String deleteByid(Book deleteObj) {
	try {
		session = factory.openSession();
		
		session.remove(deleteObj);
		
		session.beginTransaction().commit();
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if (session != null) {
			
			session.close();
		}
	}
	return returnmsg;
		
	}

	public List<Book> getbookCategory(String category) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Book.class);
			criteria.add(Restrictions.eq("bookCategory", category));
			books = criteria.list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				transaction.commit();
				session.close();
			}
		}
		return books;
	}

}
