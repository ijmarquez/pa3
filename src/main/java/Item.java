import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by walki on 5/24/2017.
 */
public class Item extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
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
        out.println("<div class=\"itemName\">");
        //insert selected item image and name
        out.println("</div>");
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
        out.println("");
        out.println("");
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

//    <?php include('header.php'); ?>
//
//
//<?php
//        require_once ('dbConnect.php');
//        $product = $_GET['product'];
//        $image = $_GET['image'];
//        $displayName = $conn->query("SELECT  `Display Name` FROM  `MainProduct` ,  `Product`
//        WHERE MainProduct.generalName =  \"$product\" && Product.Location =  \"$image\"");
//        $itemName = $displayName->fetchColumn(0);
//
//        //display item name
//        echo("<h2>");
//        echo($itemName);
//        echo("</h2>");
//
//        //display item image
//        echo('<div class="productContainer"><img id="productContainerImg" src=\'');
//        echo($image);
//        echo("'>");
//
//        ?>
//</div>
//<ul class="itemCategories">
//<li class="productList">
//<div class="productListChoice">
//<h3>Change View:</h3>
//</div>
//
//<div class="list">
//<ul class="boxList">
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
//</ul>
//</div>
//</li>
//
//<li class="sizeList">
//<div class="sizeChoice">
//<h3>Choose a Size:</h3>
//</div>
//<ul class="boxList">
//<li>
//<a title="XXSmall" class="sizeSelection" id="xxs" onclick="sizeSelect(this.id)" >XXSmall</a>
//</li>
//<li>
//<a title="XSmall" class="sizeSelection" id="xs" onclick="sizeSelect(this.id)">XSmall</a>
//</li>
//<li>
//<a title="Small" class="sizeSelection" id="s" onclick="sizeSelect(this.id)">Small</a>
//</li>
//<li>
//<a title="Medium" class="sizeSelection" id="m" onclick="sizeSelect(this.id)">Medium</a>
//</li>
//<li>
//<a title="Large" class="sizeSelection" id="l" onclick="sizeSelect(this.id)">Large</a>
//</li>
//<li>
//<a title="XLarge" class="sizeSelection" id="xl" onclick="sizeSelect(this.id)">XLarge</a>
//</li>
//<li>
//<a title="XXLarge" class="sizeSelection" id="xxl" onclick="sizeSelect(this.id)">XXLarge</a>
//</li>
//</ul>
//</li>
//</ul>
//
//<div id="btnContainer">
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
//</div>
//</div>
//
//<div class="descriptionContainer">
//<h3 id="descriptionHeader"> Description</h3>
//<?php
//        $descriptionQuery = $conn->query("SELECT  `description` FROM  `MainProduct` ,  `Product`
//        WHERE Product.`Display Name` =  \"$itemName\" && Product.productID = MainProduct.product");
//        $showDescription = $descriptionQuery->fetchColumn(0);
//        echo('<p>');
//        echo($showDescription);
//        echo('</p>');
//        ?>
//
//
//<?php include('dbClose.php');;?>
//<?php include('footer.php'); ?>
