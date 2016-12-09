package ru.rsue.bookslibrary.spring.controller;

import ru.rsue.bookslibrary.spring.model.Books;
import ru.rsue.bookslibrary.spring.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.rsue.bookslibrary.spring.service.CategoryesService;

@Controller
@RequestMapping(value = "admin")
public class BooksController {
	private BooksService booksService;
	private CategoryesService categoryesService;

	@Autowired(required=true)
	@Qualifier(value="booksService")
	public void setBooksService(BooksService booksService){
		this.booksService = booksService;
	}

	@Autowired(required = true)
	@Qualifier(value = "categoryesService")
	public void setCategoryesService(CategoryesService categoryesService){
		this.categoryesService = categoryesService;
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String listBooks(Model model) {
		model.addAttribute("books", new Books());
		model.addAttribute("listCategoryes", this.categoryesService.listCategoryes());
		model.addAttribute("listBooks", this.booksService.listBooks());
		return "admin/books";
	}

	@RequestMapping(value= "/books/add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("books") Books books){
		if(books.getId() == 0){
			this.booksService.addBook(books);
		}else{
			this.booksService.updateBook(books);
		}
		return "redirect:/admin/books";
	}
	@RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id){
        this.booksService.removeBook(id);
        return "redirect:/admin/books";
    }
    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("books", this.booksService.getBookById(id));
        model.addAttribute("listBooks", this.booksService.listBooks());
		model.addAttribute("listCategoryes", this.categoryesService.listCategoryes());
        return "admin/books";
    }
	
}
