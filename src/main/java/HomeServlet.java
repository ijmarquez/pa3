import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by irishmarquez on 5/22/17.
 */
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu/inf124-db-063";

        response.setContentType("text.html");
        PrintWriter out = response.getWriter();
        String title = "DB result";
        String docType = "<!doctype html>\n";
        out.println(docType + "<html>\n" +
                "<head>" +
                "<title>Test</title>" +
                "<body>" +

                "</body>" +
                "</head>" +
                "</html>"
        );


    }
}
