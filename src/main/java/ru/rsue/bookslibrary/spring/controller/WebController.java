package ru.rsue.bookslibrary.spring.controller;

import ru.rsue.bookslibrary.spring.model.Books;
import ru.rsue.bookslibrary.spring.model.Category;
import ru.rsue.bookslibrary.spring.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	private BooksService booksService;
	
	@Autowired(required=true)
	@Qualifier(value="booksService")
	public void setBooksService(BooksService booksService){
		this.booksService = booksService;
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String listBooks(Model model) {
		model.addAttribute("books", new Books());
		model.addAttribute("books", new Category());
		model.addAttribute("listBooks", this.booksService.listBooks());
		return "books";
	}

	@RequestMapping(value= "/books/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("books") Books books){
		
		if(books.getId() == 0){
			this.booksService.addBook(books);
		}else{
			this.booksService.updateBook(books);
		}
		
		return "redirect:/books";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
		
        this.booksService.removeBook(id);
        return "redirect:/books";
    }
 
    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("books", this.booksService.getBookById(id));
        model.addAttribute("listBooks", this.booksService.listBooks());
        return "books";
    }
	
}
