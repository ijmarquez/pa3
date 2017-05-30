import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by irishmarquez on 5/29/17.
 */
@WebServlet(name = "Test")
public class Test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //out.println("<p>In Test</p>");

        //connect to the DB information
        //final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        //final String DB_URL = Constants.getDatabaseName();
        //final String DB_USER = Constants.getUsername();
        //final String DB_PASS = Constants.getPassword();
        //Connection conn = null;
        //Statement stmt = null;
        //String sql = null;
        //ResultSet rs = null;
        //out.println("<p>after db connect</p>");

        out.println("<div style=\"background-color:green;\">hello</div>");
        RequestDispatcher rd = request.getRequestDispatcher("Test2");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
