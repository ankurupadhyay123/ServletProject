package controllers;

import dao.BlogDao;
import dao.impl.BlogDaoImpl;
import entities.Blog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

/**
 * Created by ankur on 6/7/17.
 */
public class BlogController extends HttpServlet {
    static int x = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String blogData = request.getParameter("blog");

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("savesUserName");
        session.setAttribute("savedUserBlog",blogData);

        Blog blog = new Blog();
        blog.setBlogid(x+1);
        blog.setUserName(userName);
        blog.setBlogdata(blogData);

        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        session.setAttribute("dateOfCreation",date);
        blog.setDoc(date);

        BlogDao blogDao = new BlogDaoImpl();
        blogDao.save(blog);

        RequestDispatcher r2 = request.getRequestDispatcher("profile.jsp");
        out.println("<div style='background-color:white; font-size:22px'><center>Blog Created!!</center></div>");
        r2.include(request,response);
    }
}
