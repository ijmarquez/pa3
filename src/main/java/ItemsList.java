import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by walki on 5/24/2017.
 */
public class ItemsList extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        PrintWriter out = response.getWriter();
        //header
        Constants.header(out);

        Connection conn = null;
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://sylvester-mccoy-v3-ics.uci.edu/inf124-db-063";
        final String DB_USER = "inf124-db-063";
        final String DB_PASS = "GSaxgpMPZKhN";

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
//        include('dbClose.php');
