package dao;

import entities.Blog;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ankur on 6/7/17.
 */
public interface BlogDao {
    String save(Blog blog);

//    Blog findByID(Integer id);

    Blog findByUserName(Integer blogid,String userName) throws SQLException;

    List<Blog> getuserblogs(String userName);

    List<Blog> getAll();
}
