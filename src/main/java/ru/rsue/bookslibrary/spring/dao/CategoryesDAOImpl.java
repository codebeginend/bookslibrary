package ru.rsue.bookslibrary.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.rsue.bookslibrary.spring.model.Books;
import ru.rsue.bookslibrary.spring.model.Category;

import java.util.List;

/**
 * Created by DELL on 07.12.2016.
 */
public class CategoryesDAOImpl implements CategoryesDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void addCategory(Category category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(category);
    }

    public void updateCategory(Category category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(category);
    }

    public List<Category> listCategoryes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Category> booksCategory = session.createQuery("from Category").list();
        return booksCategory;
    }

    public Category getCategoryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = (Category) session.load(Category.class, new Integer(id));
        return category;
    }

    public void removeCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = (Category) session.load(Category.class, new Integer(id));
        if(null != category){
            session.delete(category);
        }
    }
}
