package dao;

import entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

	Integer save(User user);

	User findByID(Integer id);

	User findByUserNameAndPass(String userName, String password) throws SQLException;

}
