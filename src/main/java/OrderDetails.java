import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by Calvin on 5/24/2017.
 */
public class OrderDetails extends HttpServlet {

    private ArrayList<Cart> itemList = new ArrayList<Cart>();
    private double totalCost = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        // get customer data
//        int    orderId = Integer.parseInt(request.getParameter("orderId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emaillAddress");
        String phoneNumber = request.getParameter("phoneNumber");

        String ccType = request.getParameter("ccType");

        String billAddress = request.getParameter("billAddress");
        String billCity = request.getParameter("billCity");
        String billState = request.getParameter("billState");
        int    billZipCode = Integer.parseInt(request.getParameter("billZipCode"));

        String shipAddress = request.getParameter("shipAddress");
        String shipCity = request.getParameter("shipCity");
        String shipState = request.getParameter("shipState");
        int    shipZipCode = Integer.parseInt(request.getParameter("shipZipCode"));
        String deliveryType = request.getParameter("deliveryType");

        PrintWriter out = response.getWriter();
        out.println("<p>In OrderDetails</p>");

        //header
        Constants.header(out);

        //body
        out.println("<p>Inside OrderDetails</p>");

        out.println("<div class=\"confirmContainer\">");
        out.println("<h2> Order Complete </h2>");
        out.println("<h3> Order Summary</h3>");


        int qty = 0;
        String item = "", size = "";
        NumberFormat moneyFormat = new DecimalFormat("#0.00");

        if(request.getParameter("quantity") != null) {
            qty = Integer.parseInt(request.getParameter("quantity"));
            item = request.getParameter("item");
            size = request.getParameter("size");
        }

        /* dateplaced, ordernumber, ordertotal,
        items ordered: quantity, productname
        shipping address: fname, lname, street, city, state, zip, country, shipping method
        payment method, billing address, total
        */

        out.println("<div>");
        out.println("<table class=\"shoppingCartTable\">");
        out.println("<p>ITEMS ORDERED: </p>");
        //dynamically add here
        HttpSession session = request.getSession();
        itemList = (ArrayList<Cart>) session.getAttribute("shoppingCart");
        if(itemList == null) {
            itemList = new ArrayList<Cart>();
        }

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
                out.println("<td><p> "+(i+1)+". "+itemName+"</p></td>");
                out.println("</tr>");
                out.println("<td><p>Size: "+itemSize+"</p> </td>");
                out.println(" <td><p>Quantity: <input type=\"text\" name=\"quantity\" size=\"3\" value=\""+itemQty+"\" class=\"inputReadOnly\" readonly> </p></td>");
                out.println("<td><p>Total Cost: $<input name=\"unitPrice\" value=\""+moneyFormat.format(total)+"\" class=\"inputReadOnly\" readonly> </input></p></td>");
                out.println("</tr>");
            }
        }

        //end of each item
        out.println("</table>");
        out.println("</div>");
        out.println("<br><hr>");
        out.println("<div class=\"centerOverview\">");
        out.println("<p>Total: $ <input input id=\"totalCost\" name=\"total\" value=\""+moneyFormat.format(totalCost)+"\" class=\"inputReadOnly\" readonly> </input></p>");
        out.println("</div>");

        out.println("<div>");
//        out.println("<p>OrderId: " + orderId + "</p>");
        out.println("<p>SHIPPING ADDRESS: </p>");
        out.println("<p>" + firstName + lastName + "</p>");
        out.println("<p>" + shipAddress + "</p>");
        out.println("<p>" + shipCity + ", " + shipState + " " + shipZipCode + "</p><br><br>");

        out.println("<p>SHIPPING METHOD: </p>");
        out.println("<p>" + deliveryType + "</p><br><br>");

        out.println("<p>PAYMENT METHOD: </p>");
        out.println("<p>" + ccType + "</p><br><br>");

        out.println("<p>BILLING ADDRESS: </p>");
        out.println("<p>" + firstName + lastName + "</p>");
        out.println("<p>" + billAddress + "</p>");
        out.println("<p>" + billCity + ", " + billState + " " + billZipCode + "</p><br><br>");
        out.println("</div>");
        out.println("<div id=\"submitOrder\">");
        out.println("<input id=\"btn\" type=\"submit\" value=\"Finish\" onclick=\"location.href='home'\">");
        out.println("</div>");
        //get data from server

//        <?php
//        require_once ('dbConnect.php');
//
//        $firstName = $_POST['firstName'];
//        $lastName = $_POST['lastName'];
//        $emailAddress = $_POST['emailAddress'];
//        $phoneArea = $_POST['phoneArea'];
//        $phoneThree = $_POST['phoneThree'];
//        $phoneFour = $_POST['phoneFour'];
//        $ccType = $_POST['ccType'];
//        $creditCardNumber = $_POST['creditCardNumber'];
//        $ccExpire = $_POST['ccExpire'];
//        $billAddress = $_POST['billAddress'];
//        $billCity = $_POST['billCity'];
//        $billState = $_POST['billState'];
//        $billZipCode = $_POST['billZipCode'];
//        $shipAddress = $_POST['shipAddress'];
//        $shipCity = $_POST['shipCity'];
//        $shipState = $_POST['shipState'];
//        $shipZipCode = $_POST['shipZipCode'];
//        $deliveryType = $_POST['deliveryType'];
//        $phoneNumber = $phoneArea.$phoneThree.$phoneFour;
//        $itemPurchase = $_POST['itemPurchase'];
//        $itemSize = $_POST['itemSize'];
//        $quantity = $_POST['quantity'];
//        $unitPrice = $_POST['unitPrice'];
//        $tax = $_POST['tax'];
//        $taxTotal = $_POST['taxTotal'];
//        $total = $_POST['total'];
//
//        $sql = "INSERT INTO Customer (firstName, lastName, emailAddress, phoneNumber, ccType, creditCardNumber, ccExpire,
//        billAddress, billCity, billState, billZipCode, shipAddress, shipCity, shipState, shipZipCode, deliveryType,
//                itemPurchase, itemSize, quantity, unitPrice, tax, taxTotal, total)
//        VALUES (:firstName, :lastName, :emailAddress, :phoneNumber, :ccType, :creditCardNumber, :ccExpire,
//        :billAddress, :billCity, :billState, :billZipCode, :shipAddress, :shipCity, :shipState, :shipZipCode,
//        :deliveryType, :itemPurchase, :itemSize, :quantity, :unitPrice, :tax, :taxTotal, :total)";
//
//        $stmt = $conn->prepare($sql);
//        $stmt->execute(array(
//                ':firstName' => $_POST['firstName'],
//                ':lastName' => $_POST['lastName'],
//                ':emailAddress' => $_POST['emailAddress'],
//                ':phoneNumber' => $phoneNumber,
//                ':ccType' => $_POST['ccType'],
//                ':creditCardNumber' => $_POST['creditCardNumber'],
//                ':ccExpire' => $_POST['ccExpire'],
//                ':billAddress' => $_POST['billAddress'],
//                ':billCity' => $_POST['billCity'],
//                ':billState' => $_POST['billState'],
//                ':billZipCode' => $_POST['billZipCode'],
//                ':shipAddress' => $_POST['shipAddress'],
//                ':shipCity' => $_POST['shipCity'],
//                ':shipState' => $_POST['shipState'],
//                ':shipZipCode' => $_POST['shipZipCode'],
//                ':deliveryType' => $_POST['deliveryType'],
//                'itemPurchase' => $_POST['itemPurchase'],
//                ':itemSize' => $_POST['itemSize'],
//                ':quantity' => $_POST['quantity'],
//                ':unitPrice' => $_POST['unitPrice'],
//                ':tax' => $_POST['tax'],
//                ':taxTotal' => $_POST['taxTotal'],
//                ':total' => $_POST['total'] ));
//
//
//        include ('dbClose.php');
//
//        //item info
//        echo('<p> Item ordered: '.$itemPurchase.'<br>');
//        echo('Size ordered: '.$itemSize.'<br>');
//        echo('Cost per unit: $'.$unitPrice.'<br>');
//        echo('Quantity ordered: '.$quantity.'<br>');
//        echo('Tax rate: $'.$tax.'<br>');
//        echo('Tax Total: $'.$taxTotal.'<br>');
//        echo('Total Cost: $'.$total.'</p>');
//
//        //personal info
//        echo('<h3> Personal Information</h3>');
//        echo('<p> Name: '.$firstName.' '.$lastName.'<br>');
//        echo('Email Address: '.$emailAddress.'<br>');
//        echo('Phone Number: '.$phoneNumber.'</p>');
//
//        //Billing info
//        echo('<h3> Billing Information</h3>');
//        echo('<p> Credit Card: '.$ccType.' <br>');
//        echo('Billing Address: <br>'.$billAddress.'<br> '.$billCity.' '.$billState.', '.$billZipCode.'</p>');
//
//        //Shipping info
//        echo('<h3> Shipping Information</h3>');
//        echo('<p> Shipping Address: <br>'.$shipAddress.'<br> '.$shipCity.' '.$shipState.', '.$shipZipCode.'<br>');
//        echo('Delivery Option: '.$deliveryType.'</p>');
//        ?>

//        out.println("</div>");
//        out.println("<div id=\"orderCompleteContainer\">");
//        out.println("<input id=\"btn\" type=\"submit\" value=\"Finish\" onclick=\"location.href='itemsList'\">");
//        out.println("</div>");

        //footer
        Constants.footer(out);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}



