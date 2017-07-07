package dao.impl;

import dao.BlogDao;
import entities.Blog;
import entities.User;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ankur on 6/7/17.
 */
public class BlogDaoImpl implements BlogDao {

    @Override
    public String save(Blog blog) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(blog);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + blog.toString());
        return blog.getUserName();

    }

    public List<Blog> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Blog> blogs = session.createQuery("FROM Blog").list();
        session.close();
        System.out.println("Found " + blogs.size() + " Blogs");
        return blogs;
    }

    public List<Blog> getuserblogs(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Blog> blogs = session.createQuery("select blogdata FROM Blog where userName=:userName ").setParameter("userName",userName).list();
        session.close();
        System.out.println("Found " + blogs.size() + " Blogs");
        return blogs;
    }

    @Override
    public Blog findByUserName(Integer blogid, String userName) throws SQLException {
        Query query= HibernateUtil.getSessionFactory().openSession().
                createQuery("from Blog where blogid=:blogid and userName=:userName");
        System.out.println(query);
        query.setParameter("blogid",blogid);
        query.setParameter("userName", userName);
        Blog blog = (Blog) query.uniqueResult();
        //Blog blog1 = (Blog) query.getResultList();
        return blog;
    }
}
