package ru.rsue.bookslibrary.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.rsue.bookslibrary.spring.model.Category;
import ru.rsue.bookslibrary.spring.service.CategoryesService;

/**
 * Created by zaur on 08.12.16.
 */
@Controller
@RequestMapping(value = "admin")
public class CategoriesController {
    CategoryesService categoryesService;
    @Autowired(required = true)
    @Qualifier(value = "categoryesService")
    public void setCategoryesService(CategoryesService categoryesService){
        this.categoryesService = categoryesService;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String CategoriesIndex(Model model){
        model.addAttribute("listCategoryes", this.categoryesService.listCategoryes());
        model.addAttribute("categories", new Category());
        return "admin/categories";
    }

    @RequestMapping(value= "/categories/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("categories") Category category){
        if(category.getId() == 0){
            this.categoryesService.addCategory(category);
        }else{
            this.categoryesService.updateCategory(category);
        }
        return "redirect:/admin/categories";
    }
    @RequestMapping("/categories/remove/{id}")
    public String removeCategory(@PathVariable("id") int id){
        this.categoryesService.removeCategory(id);
        return "redirect:/admin/categories";
    }
    @RequestMapping("/categories/edit/{id}")
    public String editCategory(@PathVariable("id") int id, Model model){
        model.addAttribute("categories", this.categoryesService.getCategoryById(id));
        model.addAttribute("listCategoryes", this.categoryesService.listCategoryes());
        return "admin/categories";
    }

}
