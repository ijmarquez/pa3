import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Calvin on 5/24/2017.
 */
public class ShoppingCart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
        //header
        Constants.header(out);

        //body]
        out.println("<div class=\"shoppingContainer\">");
        out.println("<h2> Shopping Cart</h2> <br><br>");
        out.println("<div>");
        out.println("<table style=\"margin-left: auto; margin-right: auto\">");
        //dynamically add here
        out.println("<tr>");
        out.println("<td><p> item 1</p></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td><p>Size: </p></td>");
        out.println(" <td><p>Quantity: <input type=\"text\" name=\"quantity\" size=\"3\" value=1 class=\"inputReadOnly\" readonly> </p></td>");
        out.println("<td><p>Cost: $<input name=\"unitPrice\" class=\"inputReadOnly\" readonly> </input></p></td>");
        out.println("</tr>");
        //end of each item
        out.println("</table>");
        out.println("</div>");
        out.println("<br><hr>");
        out.println("<div class=\"centerOverview\">");
        out.println("<p>Tax rate: $ <input id=\"taxPicked\" name=\"tax\" value=\"0\" onkeyup=\"updateTotal()\" class=\"inputReadOnly\" readonly> </input></p>");
        out.println("<p>Total Tax: $<input id=\"taxTotal\" name= 'taxTotal' class=\"inputReadOnly\" value=\"0\" readonly> </input></p>");
        out.println("<p>Total: $ <input input id=\"totalCost\" name=\"total\" value=\"20.00\" class=\"inputReadOnly\" readonly> </input></p>");
        out.println("</div>");
        out.println("<div id=\"submitOrder\">");
        out.println("<input id=\"btn\" type=\"submit\" value=\"Checkout\" onclick=\"href='BuyItem'\">");
        out.println("</div>");
        out.println("</div>");

        //footer
        Constants.footer(out);
    }
}
