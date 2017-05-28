import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by irishmarquez on 5/22/17.
 */
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
        //header
        Constants.header(out);
        //body]
        out.println(" <div class=\"home-contents\">");
        out.println("<p id=\"home-hook\">Style. Comfort. Easy.</p>");
        out.println("<a id=\"userHomeItemList\" href=\"itemsList\">Enter</a>");
        out.println("</div>");

        //footer
        Constants.footer(out);
    }
}