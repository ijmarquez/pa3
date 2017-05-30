import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by irishmarquez on 5/29/17.
 */
@WebServlet(name = "StoreOrderInDB")
public class StoreOrderInDB extends HttpServlet {



//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>In StoreOrderDB</p>");

        //connect to the DB information
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = Constants.getDatabaseName();
        final String DB_USER = Constants.getUsername();
        final String DB_PASS = Constants.getPassword();
        Connection conn = null;
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;
        out.println("<p>Small steps</p>");
        //insert each item in a loop here
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
            out.println("<p>May</p>");
            // get customer data
            int    customerId = 0;  // 0 so compiler doesn't complain about initializing
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("emailAddress");

            String phoneArea = request.getParameter("phoneArea");
            String phoneThree = request.getParameter("phoneThree");
            String phoneFour = request.getParameter("phoneFour");
            String phoneNumber = phoneArea.concat(phoneThree).concat(phoneFour);

//            out.println("<p>"+ customerId +"</p>");
//            out.println("<p>"+ firstName +"</p>");
//            out.println("<p>"+ lastName +"</p>");
//            out.println("<p>"+ emailAddress +"</p>");
//
//            out.println("<p>"+ phoneArea +"</p>");
//            out.println("<p>"+ phoneThree +"</p>");
//            out.println("<p>"+ phoneFour +"</p>");
//            out.println("<p>"+ phoneNumber +"</p>");

            String ccType = request.getParameter("ccType");
            String creditCardNumber = request.getParameter("creditCardNumber");
            String ccExpire = request.getParameter("ccExpire");

            String billAddress = request.getParameter("billAddress");
            String billCity = request.getParameter("billCity");
            String billState = request.getParameter("billState");
            int    billZipCode = Integer.parseInt(request.getParameter("billZipCode"));

            String shipAddress = request.getParameter("shipAddress");
            String shipCity = request.getParameter("shipCity");
            String shipState = request.getParameter("shipState");
            int    shipZipCode = Integer.parseInt(request.getParameter("shipZipCode"));
            String deliveryType = request.getParameter("deliveryType");

//            out.println("<p>"+ ccType +"</p>");
//            out.println("<p>"+ creditCardNumber +"</p>");
//            out.println("<p>"+ ccExpire +"</p>");
//
//            out.println("<p>"+ billAddress +"</p>");
//            out.println("<p>"+ billCity +"</p>");
//            out.println("<p>"+ billState +"</p>");
//            out.println("<p>"+ billZipCode +"</p>");
//
//            out.println("<p>"+ shipAddress +"</p>");
//            out.println("<p>"+ shipCity +"</p>");
//            out.println("<p>"+ shipState +"</p>");
//            out.println("<p>"+ shipZipCode +"</p>");
//            out.println("<p>"+ deliveryType +"</p>");



            boolean idFound = false;
            boolean isNewCustomer = false;

            // find out if customer exists
            //sql = "SELECT ID FROM Customer " + "WHERE emailAddress = " + emailAddress + ";";
            //out.println("<p>"+ sql +"</p>");
            //rs = stmt.executeQuery(ps);
            PreparedStatement ps = null;
            sql = "SELECT ID FROM Customer " + "WHERE emailAddress = ?;";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, emailAddress);    // <----------- 
           // rs = stmt
            out.println("<p>rs executed</p>");

            // if existing customer, get customerId
            while (rs.next()) {
                String email = rs.getString("emailAddress");
                out.println("<p>"+ email +"</p>");
                if (emailAddress.equals(email)) {
                    customerId = Integer.parseInt(rs.getString("ID"));
                    out.println("<p>"+ customerId +"</p>");
                    idFound = true;
                    isNewCustomer = true;
                }
                if (idFound == true)
                    break;
            }

            out.println("<p>"+ idFound +"</p>");
            out.println("<p>"+ isNewCustomer +"</p>");




//            // if new customer, insert into Customer table
//            if (idFound == false)
//            {
//                isNewCustomer = true;
//                sql = "INSERT INTO Customer " +
//                        "(firstName, lastName, emailAddress, phoneNumber, ccType," +
//                        "creditCardNumber, ccExpire, billAddress, billCity, billState, " +
//                        "billZipCode, shipAddress, shipCity, shipState, shipZipCode, " +
//                        "deliveryType, itemPurchase, itemSize, quantity, unitPrice, " +
//                        "tax, taxTotal, total)" +
//                        "VALUES (" + firstName + ", " + lastName + ", " +
//                        emailAddress + ", " + phoneNumber + ", " +
//                        ccType + ", " + creditCardNumber + ", " + ccExpire + ", " +
//                        billAddress + ", " + billCity + ", " + billState + ", " +
//                        billZipCode + ", " + shipAddress + ", " + shipCity + ", " +
//                        shipState + ", " + shipZipCode + ", " +  deliveryType + ", " +
//                        "" + ", " + "" + ", " + 0 + ", " +
//                        0 + ", " + 0 + ", " + 0 + ", " + 0 + ")";
//                //itemPurchase + ", " + itemSize + ", " + quantity + ", " +
//                //unitPrice + ", " + tax + ", " + taxTotal + ", " + total + ")";
//                stmt.executeUpdate(sql);
//            }
//
//            // then get customerId for use when storing into Orders table
//            sql = "SELECT MAX(ID) FROM Customer";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                customerId = Integer.parseInt(rs.getString("ID"));
//            }
//
//            // insert data into Orders table
//            sql = "INSERT INTO Orders (customerId) VALUES (" + customerId + ");";
//            stmt.executeUpdate(sql);
//
//            // get orderId
//            int orderId = 0;    // 0 so compiler doesn't complain about initializing
//            sql = "SELECT MAX(orderId) FROM Orders";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                orderId = Integer.parseInt(rs.getString("orderId"));
//            }
//
//            // get items from cart and insert into OrderDetails table
//            HttpSession session = request.getSession();
//            ArrayList<Cart> itemList = (ArrayList<Cart>)session.getAttribute("shoppingCart");
//            for (Cart items : itemList) {
//                String productId = items.getName();
//                double unitPrice = 10.00;
//                int quantity = items.getQty();
//                double total = unitPrice * quantity;
//
//                sql = "INSERT INTO OrderDetails (orderId, productId, unitPrice, quantity, total) " +
//                        "VALUES (" + orderId + ", " + productId + ", " + unitPrice + ", " + quantity +
//                        total + ");";
//                stmt.executeUpdate(sql);
//            }
//
            stmt.close();
            conn.close();
            out.println("<p>Lead to</p>");
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
//
//        // Previously-viewed items, param is the servlet name
//        RequestDispatcher rd = request.getRequestDispatcher("OrderDetails");
//        rd.forward(request, response);
        out.println("<p>Great successes</p>");
    }

}