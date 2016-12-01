package ru.rsue.bookslibrary.spring.dao;

import ru.rsue.bookslibrary.spring.model.Books;

import java.util.List;

public interface BooksDAO {

	public void addBook(Books books);
	public void updateBook(Books books);
	public List<Books> listBooks();
	public Books getBookById(int id);
	public void removeBook(int id);
}
