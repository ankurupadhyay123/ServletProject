package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ankur on 7/7/17.
 */
@WebServlet(name = "LogoutController")
public class LogoutController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession s = request.getSession(false);
        s.invalidate();
        PrintWriter out = response.getWriter();
        out.println("<div style='background-color:orange; font-size:22px'><center>You are successfully loggedout!!</center></div>");
        RequestDispatcher ra = request.getRequestDispatcher("welcome.jsp");
        ra.include(request, response);
    }
}
