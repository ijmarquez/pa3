import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Calvin on 5/24/2017.
 */
public class BuyItem extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        //header
        Constants.header(out);

        //body]
//        out.println("<body onload=\"getValues()\">");
        out.println("<div class=\"form\">");
        out.println("<form method=\"post\" action=\"index.php?page=insertCustomerInfo\" name=\"userInfo\" onsubmit=\"checkForm()\">");
        out.println("<div class=\"itemSelected\">");
        out.println("<h1> Customer Information </h1>");
        out.println("</div>");
        out.println("<table class=\"buyItemTableContainer\">");
        out.println("<h2 class=\"formSep\">Personal Information</h2>");
        out.println("<tr>");
        out.println("<td>First Name:</td>");
        out.println("<td><input type=\"text\" name=\"firstName\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Last Name:</td>");
        out.println("<td><input type=\"text\" name=\"lastName\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td> Email Address: </td>");
        out.println("<td> <input type=\"email\" name=\"emailAddress\"> </td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td> Phone Number: </td>");
        out.println("<td> <input type=\"tel\" name=\"phoneArea\"> - </td>");
        out.println("<td> <input type=\"tel\" name=\"phoneThree\"> - </td>");
        out.println("<td> <input type=\"tel\" name=\"phoneFour\"> </td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<table class=\"buyItemTableContainer\">");
        out.println("<h2 class=\"formSep\">Billing Information</h2>");
        out.println("<tr>");
        out.println("<td>Credit Card Type:</td>");
        out.println("<td>");
        out.println("<select name=\"ccType\">");
        out.println("<option value=\"Visa\">Visa</option>");
        out.println("<option value=\"MasterCard\">MasterCard</option>");
        out.println("<option value=\"AMEX\">AMEX</option>");
        out.println("<option value=\"Discover\">Discover</option>");
        out.println("</select>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td> Credit Card:</td>");
        out.println("<td><input type=\"text\" name=\"creditCardNumber\"> </td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td> Expiration Date:</td>\n");
        out.println("<td><input type=\"text\" name=\"ccExpire\"> </td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Billing Address: </td>");
        out.println("<td> <input type=\"text\" name=\"billAddress\"> </td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>City: </td>");
        out.println("<td>");
        out.println("<input type=\"text\" name=\"billCity\" id=\"billCity\" class=\"city\" onkeyup=\"getState(this.id)\">");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>State: </td>");
        out.println("<td> <input type=\"text\" name=\"billState\" id=\"billState\"> </td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Zip Code: </td>");
        out.println("<td> <input type=\"text\" name=\"billZipCode\" onblur=\"getZip(this.value, billCity, billState)\"> </td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<table class=\"buyItemTableContainer\">");
        out.println("<h2 class=\"formSep\"> Shipping Information</h2>");
        out.println("<tr>");
        out.println("<td>Shipping Address: </td>");
        out.println("<td> <input type=\"text\" name=\"shipAddress\"></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>City: </td>");
        out.println("<td>");
        out.println("<input type=\"text\" name=\"shipCity\" id=\"shipCity\" class=\"city\" onkeyup=\"getState(this.id)\">");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>State: </td>");
        out.println("<td> <input type=\"text\" name=\"shipState\" id=\"shipState\"> </td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Zip Code: </td>");
        out.println("<td> <input type=\"text\" name=\"shipZipCode\" onblur=\"getZip(this.value, shipCity, shipState)\"> </td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>Delivery Option: </td>");
        out.println("<td>");
        out.println("<select id=\"deliveryType\" name=\"deliveryType\" onchange=\"updateTotal()\">");
        out.println("<option value=\"Overnight\" selected=\"selected\">Overnight.....$10</option>");
        out.println("<option value=\"2 Days\" >    2 Days.........$5</option>");
        out.println("<option value=\"7-10Days\" > 7-10 Days......$3</option>");
        out.println("</select>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<div class=\"costContainer\">");
        out.println("<h2 class=\"formSep\">Overview</h2>");
        out.println("<div class=\"centerOverview\">");
        out.println("<p>Cost: $<input id=\"costPicked\" name=\"unitPrice\" class=\"inputReadOnly\" readonly> </input></p>");
        out.println("Quantity:");
        out.println("<input id=\"quantity\" type=\"text\" name=\"quantity\" size=\"3\" value=1 onkeyup=\"updateTotal()\"> <br>");
        out.println("<p>Tax rate: $ <input id=\"taxPicked\" name=\"tax\" value=\"0\" onkeyup=\"updateTotal()\" class=\"inputReadOnly\" readonly> </input></p>");
        out.println("<p>Total Tax: $<input id=\"taxTotal\" name= 'taxTotal' class=\"inputReadOnly\" value=\"0\" readonly> </input></p>");
        out.println("<p>Total: $ <input input id=\"totalCost\" name=\"total\" value=\"20.00\" class=\"inputReadOnly\" readonly> </input></p>");
        out.println("</div>");
        out.println("<div id=\"submitOrder\">");
        out.println("<input id=\"btn\" type=\"submit\" value=\"Submit Order\" onclick=\"return checkForm(); return false\">");
        out.println("</div>");
        out.println("</div>");
        out.println("</form>");
        out.println("</div>");


        //footer
        Constants.footer(out);
    }
}



