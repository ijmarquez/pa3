import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        char temp [] = request.getParameter("product").toCharArray();
        char copy [] = new char[temp.length-2];
        for(int i = 0; i < temp.length - 2;++i) {
            copy[i] = temp[i+1];
        }

        final String generalName = String.valueOf(copy);
        final String productLocation = request.getParameter("image").replaceAll("[']","");


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
                String itemName = rs.getString("Display Name");
                out.println("<h2>");
                out.println(itemName);
                out.println("</h2>");
            }

            conn = null;
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
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            stmt = conn.createStatement();
            String sql = "SELECT `Display Name` FROM  `MainProduct` ,  `Product` WHERE MainProduct.generalName =  \""+ generalName +"\" && Product.Location =  \""+productLocation+"\"";
//            String sql = "SELECT `Display Name` FROM  MainProduct , Product WHERE MainProduct.generalName = \""+generalName+"\" && Product.Location = \"" + productLocation +"\"";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                String itemName = rs.getString("Display Name");
                out.println("<h2>");
                out.println(itemName);
                out.println("</h2>");
            }

            conn = null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println(e);
        } catch (SQLException e) {
            out.println(e);
        }
        //show differnt color clothes
        //<?php
//        $stmt = $conn-> query("SELECT  `Location` ,  `Display Name` ,  `description`, `generalName` FROM  `Product` ,  `MainProduct`
//        WHERE MainProduct.generalName =  \"$product\" && MainProduct.ID = Product.ID");
//        while($row = $stmt->fetch(PDO::FETCH_ASSOC)) {
//        echo('<li class="itemList"> ');
//        echo('<a class="items" href="item.php?product='.$row['generalName'].'&amp;image='.$row['Location'].'">');
//        echo('<img class="itemImg" src="'.$row['Location'].'">');
//        echo('</a></li>');
//        }
//
//        ?>
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

        //<?php
//        $btnQuery = $conn->query("SELECT  `cost` FROM  `MainProduct` ,  `Product`
//        WHERE Product.`Display Name` =  \"$itemName\" && Product.productID = MainProduct.product");
//        $showCost = $btnQuery->fetchColumn(0);
//
//        //show cost
//        echo('<p id="cost">$');
//        echo($showCost);
//        echo('</p>');
//
//        //submit button
//        echo('<input id="btn" type="button" value="BUY NOW" onclick="buyItem(\''.$image.'\', \''.$itemName.'\')"/>');
//        ?>

        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"descriptionContainer\">");
        out.println("<h3 id=\"descriptionHeader\"> Description</h3>");

        //get description for the server and put it here

        //<?php
//        $descriptionQuery = $conn->query("SELECT  `description` FROM  `MainProduct` ,  `Product`
//        WHERE Product.`Display Name` =  \"$itemName\" && Product.productID = MainProduct.product");
//        $showDescription = $descriptionQuery->fetchColumn(0);
//        echo('<p>');
//        echo($showDescription);
//        echo('</p>');
//        ?>

        out.println("");
        out.println("");
        out.println("");
        out.println("");
        out.println("");
        out.println("");
        out.println("");
        out.println("");
        out.println("");
        out.println("");
        out.println("</div>");

        //footer
        Constants.footer(out);
    }
}


