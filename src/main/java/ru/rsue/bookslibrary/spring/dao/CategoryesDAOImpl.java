package ru.rsue.bookslibrary.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rsue.bookslibrary.spring.model.Books;
import ru.rsue.bookslibrary.spring.model.Category;

import java.util.List;

/**
 * Created by DELL on 07.12.2016.
 */
public class CategoryesDAOImpl implements CategoryesDAO {

    private static final Logger logger = LoggerFactory.getLogger(CategoryesDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void addCategory(Category category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(category);
        logger.info("Category saved successfully, Category Details="+category);
    }

    public void updateCategory(Category category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(category);
        logger.info("Category updated successfully, Category Details="+category);
    }

    public List<Category> listCategoryes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Category> booksCategory = session.createQuery("from Category").list();
        for(Category category : booksCategory){
            logger.info("Category List::"+category);
        }
        return booksCategory;
    }

    public Category getCategoryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = (Category) session.load(Category.class, new Integer(id));
        logger.info("Category loaded successfully, Category details="+category);
        return category;
    }

    public void removeCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = (Category) session.load(Category.class, new Integer(id));
        if(null != category){
            session.delete(category);
        }
        logger.info("Category deleted successfully, category details="+category);
    }
}
