import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ankur on 28/6/17.
 */
public class myServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter pd = response.getWriter();
        pd.write("working");
    }
}
