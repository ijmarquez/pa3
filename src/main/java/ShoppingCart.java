import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Calvin on 5/24/2017.
 */
public class ShoppingCart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String quantity = request.getParameter("quantity");
        String item = request.getParameter("itemName");
        String button = request.getParameter("addButton");
        HttpSession s;
        if(button != null) {
            s = request.getSession(true);
            s.setAttribute(item, quantity);
//            Cookie cookie = new Cookie(item, quantity);
//            response.addCookie(cookie);
//            response.sendRedirect("ShoppingCart");
        }

        PrintWriter out = response.getWriter();
        //header
        Constants.header(out);

        s = request.getSession(true);
        String test = (String) s.getAttribute("itemName");
        out.println("<p>" + test + "</p>");
        //body]
        out.println("<div class=\"shoppingContainer\">");
        out.println("<h2> Shopping Cart</h2> <br><br>");
        out.println("<div>");
        out.println("<table style=\"margin-left: auto; margin-right: auto\">");
        //dynamically add here

//        Cookie clientCookies[] = request.getCookies();
//        for(int i = 0; i< clientCookies.length;++i) {
//            out.print("<B>" + clientCookies[i].getName() + " : " + clientCookies[i].getValue() + "</B><BR>");
//        }

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
        out.println("<input id='btn' type='submit' value='Checkout' onclick=\"location.href='BuyItem'\">");
        out.println("</div>");
        out.println("</div>");

        //footer
        Constants.footer(out);
    }
}
