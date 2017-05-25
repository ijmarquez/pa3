import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


/**
 * Created by walki on 5/24/2017.
 */
@WebServlet("/ItemsList")
public class ItemsList extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        //connect to the DB information
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = Constants.getDatabaseName();
        final String DB_USER = Constants.getUsername();
        final String DB_PASS = Constants.getPassword();
        Connection conn = null;
        Statement stmt = null;

        PrintWriter out = response.getWriter();
        //header
        Constants.header(out);

        //out.println("<p> this is where it'll show the list of different items </p>");
        out.println("<div class=\"items-container\">");
        out.println("<div class=\"items-contents\">");
        out.println("<table class=\"itemListTable\">");

        //insert each item in a loop here
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            stmt = conn.createStatement();
            String sql = "SELECT * FROM MainProduct";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 1;
            while (rs.next())
            {
                if ( i == 1) {
                    out.println("<tr>");
                }
                if(i == 5) {
                    out.println("</tr>");
                    i = 1;
                }
                out.println("<td>");

                String generalName = rs.getString("generalName");
                String imageLocation = rs.getString("imageLocation");
                String cost = rs.getString("cost");

                out.println("<div class='image_thumbnail_holder'>");
                out.println("<a href=\"Item?product='"+generalName+"'&amp;image='"+imageLocation+"'\">");
                out.println("<img class=\"image_thumbnail\" src= \""+ imageLocation +"\" alt= \""+ generalName+"\">");
                out.println("</a></div>");

                //display item name
                out.println("<div class='items-name'><p>");
                out.println(generalName);
                out.println("</p></div>");

                //displayy item prices
                out.println("<div class='items-price'><p>");
                out.println(cost);
                out.println("</p></div>");

                //end of column
                out.println("</td>");
                i++;

//                out.println("<p> GeneralName: " + generalName + "</p>");
//                out.println("<p> imageLocation: " + imageLocation + "</p>");
//                out.println("<p> Cost: " + cost + "</p>");
//                out.println("</div>");
            }
        }
        catch (ClassNotFoundException e)
        {
            out.println("<p> CLASS NOT FOUND </p>");
            e.printStackTrace();
        }
        catch (SQLException se)
        {
            out.println(se);
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
        out.println("</table>");
        out.println("</div>");
        out.println("</div>");

        //footer
        Constants.footer(out);
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
