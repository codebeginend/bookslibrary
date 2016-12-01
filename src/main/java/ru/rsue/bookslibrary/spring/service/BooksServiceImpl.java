package ru.rsue.bookslibrary.spring.service;

import ru.rsue.bookslibrary.spring.dao.BooksDAO;
import ru.rsue.bookslibrary.spring.model.Books;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
	
	private BooksDAO booksDAO;

	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}

	@Transactional
	public void addBook(Books books) {
		this.booksDAO.addBook(books);
	}

	@Transactional
	public void updateBook(Books books) {
		this.booksDAO.updateBook(books);
	}

	@Transactional
	public List<Books> listBooks() {
		return this.booksDAO.listBooks();
	}

	@Transactional
	public Books getBookById(int id) {
		return this.booksDAO.getBookById(id);
	}

	@Transactional
	public void removeBook(int id) {
		this.booksDAO.removeBook(id);
	}

}
