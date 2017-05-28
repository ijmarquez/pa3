import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Calvin on 5/24/2017.
 */
public class ShoppingCart extends HttpServlet {
    Cart shoppingCart;
    private double total = 0;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
//        String quantity = request.getParameter("quantity");
//        String item = request.getParameter("itemName");
//        String button = request.getParameter("addButton");
//        HttpSession s;
//        if(button != null) {
//            s = request.getSession(true);
//            s.setAttribute(item, quantity);
////            Cookie cookie = new Cookie(item, quantity);
////            response.addCookie(cookie);
////            response.sendRedirect("ShoppingCart");
//        }

        int qty = Integer.parseInt(request.getParameter("quantity"));
        String item = request.getParameter("item");

        HttpSession s = request.getSession();
        if(shoppingCart == null) {
            shoppingCart = new Cart();
            s.setAttribute("shoppingCart", shoppingCart);
        }
        else {
            shoppingCart = (Cart) s.getAttribute("shoppingCart");
        }

        PrintWriter out = response.getWriter();
        //header
        Constants.header(out);

        //body]
        out.println("<div class=\"shoppingContainer\">");
        out.println("<h2> Shopping Cart</h2> <br><br>");
        out.println("<div>");
        out.println("<table style=\"margin-left: auto; margin-right: auto\">");
        //dynamically add here
        if(!shoppingCart.getCart().isEmpty()) {
            HashMap<String, Integer> temp = shoppingCart.getCart();
            for(String key : temp.keySet()) {
                int currQty = temp.get(key);
                out.println("<tr>");
                out.println("<td><p> "+key+"</p></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td><p>Size: </p></td>");
                out.println(" <td><p>Quantity: <input type=\"text\" name=\"quantity\" size=\"3\" value=\""+currQty+"\" class=\"inputReadOnly\" readonly> </p></td>");
                total = currQty*10;
            }
        }
        out.println("<td><p>Total Cost: $<input name=\"unitPrice\" value=\""+total+"\" class=\"inputReadOnly\" readonly> </input></p></td>");
        out.println("</tr>");

//        out.println("<tr>");
//        out.println("<td><p> item 1</p></td>");
//        out.println("</tr>");
//        out.println("<tr>");
//        out.println("<td><p>Size: </p></td>");
//        out.println(" <td><p>Quantity: <input type=\"text\" name=\"quantity\" size=\"3\" value=1 class=\"inputReadOnly\" readonly> </p></td>");
//        out.println("<td><p>Cost: $<input name=\"unitPrice\" class=\"inputReadOnly\" readonly> </input></p></td>");
//        out.println("</tr>");
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
