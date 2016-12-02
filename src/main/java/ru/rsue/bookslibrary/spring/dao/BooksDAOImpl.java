package ru.rsue.bookslibrary.spring.dao;

import ru.rsue.bookslibrary.spring.model.Books;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooksDAOImpl implements BooksDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addBook(Books books) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(books);
	}


	public void updateBook(Books books) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(books);
	}

	@SuppressWarnings("unchecked")
	public List<Books> listBooks() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Books> booksList = session.createQuery("from Books").list();
		for(Books books : booksList){
		}
		return booksList;
	}

	public Books getBookById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Books books = (Books) session.load(Books.class, new Integer(id));
		return books;
	}

	public void removeBook(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Books books = (Books) session.load(Books.class, new Integer(id));
		if(null != books){
			session.delete(books);
		}
	}

}
