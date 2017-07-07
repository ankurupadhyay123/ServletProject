package controllers;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entities.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int i = 0;

	public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String uname = request.getParameter("userName");
		String pass = request.getParameter("passWord");
		String dob = request.getParameter("dob");
		/*if(fname.isEmpty()||lname.isEmpty()||email.isEmpty()||uname.isEmpty()||pass.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("form.html");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{*/
			User user=new User();
			user.setUserId(i+1);
			user.setFirstName(fname);
			user.setLastName(lname);
			user.setEmail(email);
			user.setUserName(uname);
			user.setPassword(pass);

			java.sql.Date date = java.sql.Date.valueOf(dob);
			user.setDob(date);


		UserDao userDao=new UserDaoImpl();

			userDao.save(user);

			RequestDispatcher r2 = request.getRequestDispatcher("welcome.jsp");
			out.println("<div style='background-color:green; font-size:22px'><center>You are successfully Registered!!</center></div>");
			r2.include(request,response);
	}

}
