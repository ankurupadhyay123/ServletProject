package controllers;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entities.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

/*
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		// TODO: Good to have: create a util to get session / setting attribute and getting attribute
		HttpSession session = request.getSession();
		session.setAttribute("savesUserName",uname);
		session.setAttribute("savesPassword",pass);

			UserDao userDao=new UserDaoImpl();
			User user= null;
			try {
				user = userDao.findByUserNameAndPass(uname, pass);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(user!=null){
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp?uname="+user.getFirstName());
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				out.println("<div style='background-color:red; font-size:22px'><center>Invalid User!!</center></div>");
				rd.include(request, response);
			}
			
	}
}
