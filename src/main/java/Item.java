import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by walki on 5/24/2017.
 */
public class Item extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //connect to the DB information
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = Constants.getDatabaseName();
        final String DB_USER = Constants.getUsername();
        final String DB_PASS = Constants.getPassword();
        Connection conn = null;
        Statement stmt = null;

        response.setContentType("text/html; charset=UTF-8");
        char temp [] = request.getParameter("product").toCharArray();
        char copy [] = new char[temp.length-2];
        for(int i = 0; i < temp.length - 2;++i) {
            copy[i] = temp[i+1];
        }

        final String generalName = String.valueOf(copy);
        final String productLocation = request.getParameter("image").replaceAll("[']","");
        String itemName = "";

        PrintWriter out = response.getWriter();
        //header
        Constants.header(out);

        //body]
        out.println("<div class=\"itemName\">");
        //insert selected item image and name

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            stmt = conn.createStatement();
            String sql = "SELECT `Display Name` FROM  `MainProduct` ,  `Product` WHERE MainProduct.generalName =  \""+ generalName +"\" && Product.Location =  \""+productLocation+"\"";
//            String sql = "SELECT `Display Name` FROM  MainProduct , Product WHERE MainProduct.generalName = \""+generalName+"\" && Product.Location = \"" + productLocation +"\"";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                itemName = rs.getString("Display Name");
                out.println("<h2>");
                out.println(itemName);
                out.println("</h2>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println(e);
        } catch (SQLException e) {
            out.println(e);
        }

        out.println("<div class=\"productContainer\"><img id=\"productContainerImg\" src=\"");
        out.println(productLocation + "\">");
        out.println("</div>");

        out.println("<ul class=\"itemCategories\">");
        out.println("<li class=\"productList\">");
        out.println("<div class=\"productListChoice\">");
        out.println("<h3>Change View:</h3>");
        out.println("</div>");
        out.println("<div class=\"list\">");
        out.println("<ul class=\"boxList\">");

        try {
            stmt = conn.createStatement();
            String sql = "SELECT  `Location`,  `Display Name`, `description`, `generalName` FROM  `Product`, `MainProduct`\n" +
                    "WHERE MainProduct.generalName = \""+generalName+"\" && MainProduct.ID = Product.ID";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String DisplayName = rs.getString("Display Name");
                String gName = rs.getString("generalName");
                String imageLocation = rs.getString("Location");

                out.println("<li class='itemList'>");
                out.println("<a href=\"Item?product='"+gName+"'&amp;image='"+imageLocation+"'\">");
                out.println("<img class=\"itemImg\" src= \""+ imageLocation +"\" alt= \""+ generalName+"\">");
                out.println("</a></li>");
            }
        }catch (SQLException e) {
            out.println(e);
        }

        out.println("</ul>");
        out.println("</div>");
        out.println("</li>");
        out.println("<li class=\"sizeList\">");
        out.println("<div class=\"sizeChoice\">");
        out.println("<h3>Choose a Size:</h3>");
        out.println("</div>");
        out.println("<ul class=\"boxList\">");
        out.println("<li>");
        out.println("<a title=\"XXSmall\" class=\"sizeSelection\" id=\"xxs\" onclick=\"sizeSelect(this.id)\" >XXSmall</a>");
        out.println("</li>");
        out.println("<li>");
        out.println("<a title=\"XSmall\" class=\"sizeSelection\" id=\"xs\" onclick=\"sizeSelect(this.id)\">XSmall</a>");
        out.println("</li>");
        out.println("<li>");
        out.println("<a title=\"Small\" class=\"sizeSelection\" id=\"s\" onclick=\"sizeSelect(this.id)\">Small</a>");
        out.println("</li>");
        out.println("<li>");
        out.println("<a title=\"Medium\" class=\"sizeSelection\" id=\"m\" onclick=\"sizeSelect(this.id)\">Medium</a>");
        out.println("</li>");
        out.println("<li>");
        out.println("<a title=\"Large\" class=\"sizeSelection\" id=\"l\" onclick=\"sizeSelect(this.id)\">Large</a>");
        out.println("</li>");
        out.println("<li>");
        out.println("<a title=\"XLarge\" class=\"sizeSelection\" id=\"xl\" onclick=\"sizeSelect(this.id)\">XLarge</a>");
        out.println("</li>");
        out.println("<li>");
        out.println("<a title=\"XXLarge\" class=\"sizeSelection\" id=\"xxl\" onclick=\"sizeSelect(this.id)\">XXLarge</a>");
        out.println("</li>");
        out.println("</ul>");
        out.println("</li>");
        out.println("</ul>");


        out.println("<div id=\"btnContainer\">");
        //get item price
        try {
            stmt = conn.createStatement();
            String sql = "SELECT `cost` FROM `MainProduct` , `Product`\n" +
                    "WHERE Product.`Display Name` =  \"" +itemName+"\" && Product.productID = MainProduct.product";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                String showCost = rs.getString("cost");

                out.println("<p id='cost'> $");
                out.println(showCost);
                out.println("</p>");
            }
        }catch (SQLException e) {
            out.println(e);
        }
        out.print("<form action='ShoppingCart' method='post'>");
        out.println("Quantity: <input id='quantity' type='text' name=\"quantity\" size='3' value=1> <br><br>"); //onkeyup="updateTotal()"
        out.println("<input id = 'item' type='text' name='itemName' value=\""+itemName+"\" hidden>");
        //submit button
        out.println("<input id=\"btn\" type=\"button\" value=\"Add to cart\" name=\"addButton\"onclick=\"addToCart('"+productLocation+"', '"+itemName+"')\"/>");
        out.println("</form>");

        String quantity = request.getParameter("quantity");
        String item = request.getParameter("itemName");
        String button = request.getParameter("addButton");
        HttpSession s;
        if(button != null) {
            s = request.getSession(true);
            s.setAttribute(item, quantity);
            out.println("<p> ADD PRESSED </p>");
        }

        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"descriptionContainer\">");
        out.println("<h3 id=\"descriptionHeader\"> Description</h3>");

        //get description for the server and put it here
        try {
            stmt = conn.createStatement();
            String sql = "SELECT  `description` FROM  `MainProduct` ,  `Product`\n" +
                    "WHERE Product.`Display Name` =  \""+itemName +"\" && Product.productID = MainProduct.product";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String showDescription = rs.getString("description");
                out.println("<p>");
                out.println(showDescription);
                out.println("</p>");
            }
        }catch (SQLException e) {
            out.println(e);
        }

        finally
        {
            try
            {
                if (stmt != null)
                    stmt.close();
            }
            catch (SQLException se2)
            {
                try
                {
                    if (conn != null)
                        conn.close();
                }
                catch (SQLException se)
                {
                    se.printStackTrace();
                }
            }
        }
        out.println("</div>");

        //footer
        Constants.footer(out);
    }
}


