package dao.impl;

import dao.UserDao;
import entities.User;
import utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

	public Integer save(User e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully created " + e.toString());
		return e.getUserId();

	}

	public List<User> get() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<User> Users = session.createQuery("FROM User").list();
		session.close();
		System.out.println("Found " + Users.size() + " Users");
		return Users;

	}

	public void update(User e) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User em = (User) session.load(User.class, e.getUserId());
		em.setLastName(e.getLastName());
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully updated " + e.toString());

	}

	public void delete(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User e = findByID(id);
		session.delete(e);
		session.getTransaction().commit();
		session.close();
		System.out.println("Successfully deleted " + e.toString());

	}

	public User findByID(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User e = (User) session.load(User.class, id);
		session.close();
		return e;
	}
	
	public User findByUserNameAndPass(String userName, String password) throws SQLException {
		Query query= HibernateUtil.getSessionFactory().openSession().
				createQuery("from User where userName=:userName and password=:password");
		System.out.println(query);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		User user = (User) query.uniqueResult();
		return user;
	}

}
