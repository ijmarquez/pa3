import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Calvin on 5/24/2017.
 */
public class OrderDetails extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
        //header
        Constants.header(out);

        //body
        out.println("<div class=\"confirmContainer\">");
        out.println("<h2> Order Complete </h2>");
        out.println("<h3> Order Summary</h3>");

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

        out.println("</div>");
        out.println("<div id=\"orderCompleteContainer\">");
        out.println("<input id=\"btn\" type=\"submit\" value=\"Finish\" onclick=\"location.href='itemsList'\">");
        out.println("</div>");

        //footer
        Constants.footer(out);
    }
}



