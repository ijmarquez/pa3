import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Calvin on 5/24/2017.
 */
public class ShoppingCart extends HttpServlet {
    Cart shoppingCart;
    private ArrayList<Cart> itemList = new ArrayList<Cart>();
    private double totalCost = 0;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        int qty = 0;
        String item = "", size = "";
        NumberFormat moneyFormat = new DecimalFormat("#0.00");

        if(request.getParameter("quantity") != null) {
            qty = Integer.parseInt(request.getParameter("quantity"));
            item = request.getParameter("item");
            size = request.getParameter("size");
        }

        //start||get  session
        HttpSession session = request.getSession();
        itemList = (ArrayList<Cart>) session.getAttribute("shoppingCart");
        if(itemList == null) {
            itemList = new ArrayList<Cart>();
        }
//        if(shoppingCart == null) {
//            shoppingCart = new Cart();
//            s.setAttribute("shoppingCart", shoppingCart);
//        }

        //when qty or item has data
        if(qty != 0 && item != "" && size != "") {
            Cart currentItem = new Cart(item, qty, size);
//            if(!itemList.contains(currentItem))
                itemList.add(currentItem);
        }

        session.setAttribute("shoppingCart", itemList);

        PrintWriter out = response.getWriter();
//        out.println("<p> item: " + item + "</p>");
//        out.println("<p> size: " + size + "</p>");
//        out.println("<p> qty: " + qty + "</p>");
        //header
        Constants.header(out);

        //body]
        out.println("<div class=\"shoppingContainer\">");
        out.println("<h2> Shopping Cart</h2> <br><br>");
        out.println("<div>");
        out.println("<table class=\"shoppingCartTable\">");
        //dynamically add here
        if(itemList!=null || itemList.size() != 0) {
            totalCost = 0;
            for (int i =0 ; i < itemList.size(); ++i) {
                Cart itemPick = itemList.get(i);
                final String itemName = itemPick.getName();
                final int itemQty = itemPick.getQty();
                final String itemSize = itemPick.getSize();
                final int total = (itemQty * 10);
                itemList.get(i).setTotalCost(total);
                totalCost += total;
                out.println("<tr>");
//                out.println("<td>"+(i+1)+". </td>");
                out.println("<td><p> "+(i+1)+". "+itemName+"</p></td>");
                out.println("</tr>");
//                out.println("<tr><td></td>");
                out.println("<td><p>Size: "+itemSize+"</p> </td>");
                out.println(" <td><p>Quantity: <input type=\"text\" name=\"quantity\" size=\"3\" value=\""+itemQty+"\" class=\"inputReadOnly\" readonly> </p></td>");
                out.println("<td><p>Total Cost: $<input name=\"unitPrice\" value=\""+moneyFormat.format(total)+"\" class=\"inputReadOnly\" readonly> </input></p></td>");
                out.println("</tr>");
            }

//            for(String key : temp.keySet()) {
//                int currQty = temp.get(key);
//                out.println("<tr>");
//                out.println("<td><p> "+key+"</p></td>");
//                out.println("</tr>");
//                out.println("<tr>");
//                out.println("<td><p>Size: </p></td>");
//                out.println(" <td><p>Quantity: <input type=\"text\" name=\"quantity\" size=\"3\" value=\""+currQty+"\" class=\"inputReadOnly\" readonly> </p></td>");
//                total = currQty*10;
//            }
        }


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
        out.println("<p>Total: $ <input input id=\"totalCost\" name=\"total\" value=\""+moneyFormat.format(totalCost)+"\" class=\"inputReadOnly\" readonly> </input></p>");
        out.println("</div>");
        out.println("<div id=\"submitOrder\">");
        out.println("<input id='btn' type='submit' value='Checkout' onclick=\"location.href='BuyItem'\">");
        out.println("</div>");
        out.println("</div>");

        //footer
        Constants.footer(out);
    }
}
