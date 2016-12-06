package ru.rsue.bookslibrary.spring.dao;

import ru.rsue.bookslibrary.spring.model.Category;
import java.util.List;

/**
 * Created by DELL on 07.12.2016.
 */
public interface CategoryesDAO {
    public void addCategory(Category category);
    public void updateCategory(Category category);
    public List<Category> listCategoryes();
    public Category getCategoryById(int id);
    public void removeCategory(int id);
}
