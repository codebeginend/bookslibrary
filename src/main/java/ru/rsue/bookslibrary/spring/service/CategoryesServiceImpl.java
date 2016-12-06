package ru.rsue.bookslibrary.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rsue.bookslibrary.spring.dao.CategoryesDAO;
import ru.rsue.bookslibrary.spring.model.Category;

import java.util.List;

/**
 * Created by DELL on 07.12.2016.
 */
@Service
public class CategoryesServiceImpl implements CategoryesService {
    private CategoryesDAO categoryesDAO;

    public void setCategoryesDAO(CategoryesDAO categoryesDAO) {
        this.categoryesDAO = categoryesDAO;
    }

    @Transactional
    public void addCategory(Category category) {
        categoryesDAO.addCategory(category);
    }
    @Transactional
    public void updateCategory(Category category) {
        categoryesDAO.updateCategory(category);
    }
    @Transactional
    public List<Category> listCategoryes() {
        return categoryesDAO.listCategoryes();
    }
    @Transactional
    public Category getCategoryById(int id) {
        return categoryesDAO.getCategoryById(id);
    }
    @Transactional
    public void removeCategory(int id) {
        categoryesDAO.removeCategory(id);
    }
}
