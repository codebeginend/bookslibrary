package ru.rsue.bookslibrary.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zaur on 08.12.16.
 */
@Controller
@RequestMapping(value = "admin")
public class CategoriesController {

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String CategoriesIndex(Model model){
        return "categories";
    }
}
