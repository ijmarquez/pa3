import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by walki on 5/24/2017.
 */
public class ItemsList extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
        //header
        Constants.header(out);

        //body]
        out.println("<p> this is where it'll show the list of different items </p>");
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
