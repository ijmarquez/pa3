import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.lang.Class.forName;

/**
 * Created by walki on 5/24/2017.
 */
public class ItemsList extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://sylvester-mccoy-v3-ics.uci.edu/inf124-db-063";
        final String DB_USER = "inf124-db-063";
        final String DB_PASS = "GSaxgpMPZKhN";


        PrintWriter out = response.getWriter();
        //header
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/header_footer.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/home.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/footerContent.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/items_list.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/items.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/buyItem.css\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/customerOrder.css\">");
        out.println("<script type=\"text/javascript\" src=\"js/buyItem.js\"></script>");
        out.println("<script type=\"text/javascript\" src=\"js/Item.js\"></script>");
        out.println("<link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">");
        out.println("<script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>");
        out.println("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js\"></script>");
        out.println("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css\" rel=\"stylesheet\">");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js\"></script>");
        out.println("<link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" rel=\"stylesheet\">");
        out.println("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js\"></script>");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-3-typeahead/4.0.1/bootstrap3-typeahead.min.js\"></script>");
        out.println("</head>");
        out.println("<title> Clothing Couture </title>");
        out.println("<body>");
        out.println("<div class=\"pageContainer\">");
        out.println("<div class=\"homeContainer\">");
        out.println("<div class=\"home-logo\">");
        out.println("<h1>Clothing Couture</h1>");
        out.println("</div>");
        out.println("<div class=\"navMenu\">");
        out.println("<ul class=\"navBar\">");
        out.println("<li>  <a class=\"userOption\" href=\"home\"> Home </a> </li>");
        out.println("</ul>");
        out.println("</div>");
        out.println("</div>");

        //body]
        Connection conn = null;
        Statement stmt = null;
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            stmt = conn.createStatement();
            String sql = "SELECT cost, generalName, imageLocation FROM MainProduct";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                    String generalName = rs.getString("generalName");
                    String product = rs.getString("product");
                    //double cost = rs.getString("cost");
                    out.println("GeneralName: " + generalName);
                    out.println(" Product: " + product + "<br>");
            }

        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException se)
        {
            se.printStackTrace();
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


        //out.println("<p> this is where it'll show the list of different items </p>");
        out.println("<div class=\"items-container\">");
        out.println("<div class=\"items-contents\">");
        out.println("<table class=\"itemListTable\">");
        //insert each item in a loop here
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
        out.println("");
        out.println("");
        out.println("");
        out.println("</table>");
        out.println("</div>");
        out.println("</div>");

        //footer
        out.println("<footer>");
        out.println("<div class=\"footer\">");
        out.println("<a class=\"footerOption\" href=\"about.php\">about us</a>");
        out.println("<a class=\"footerOption\" href=\"contact.php\">contact us</a>");
        out.println("</div>");
        out.println("</footer>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}



//        require_once('dbConnect.php');
//
//        $stmt= $conn->query("SELECT cost, generalName, imageLocation FROM MainProduct");
//        $i = 1;
//        while($row = $stmt->fetch(PDO::FETCH_ASSOC) ) {
//        if($i == 1) {
//        echo"<tr>";
//        }
//        if ($i == 5) {
//        echo "</tr>";
//        $i=1;
//        }
//        //create column
//        echo "<td> \n";
//
//        //display Item
//        echo "<div class='image_thumbnail_holder'>";
//        echo('<a href="Item.php?product='.$row['generalName'].'&amp;image='.$row['imageLocation'].'">');
//        echo('<img class="image_thumbnail" src="'.$row['imageLocation'].'" alt="'.$row['generalName'].'">');
//        echo "</a></div>";
//        //display Item name
//        echo "<div class='items-name'><p>";
//        echo($row['generalName']);
//        echo "</p></div>";
//
//        //display Item prices
//        echo "<div class='items-price'><p>";
//        echo("$".$row['cost']);
//        echo "</p></div>";
//
//        //end of column
//        echo"</td> \n";
//        $i++;
//        };
//        include('dbClose.php');
