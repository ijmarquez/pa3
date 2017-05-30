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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //PrintWriter out = response.getWriter();
        //out.println("<p>In StoreOrderDB</p>");

        //connect to the DB information
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = Constants.getDatabaseName();
        final String DB_USER = Constants.getUsername();
        final String DB_PASS = Constants.getPassword();
        Connection conn = null;
        Statement stmt = null;
        String sql = null;
        ResultSet rs = null;

        PrintWriter out = response.getWriter();

        //insert each item in a loop here
        try
        {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();

            // get customer data
            int    customerId = 0;  // 0 so compiler doesn't complain about initializing
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("emaillAddress");
            String phoneNumber = request.getParameter("phoneNumber");

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


            boolean idFound = false;
            boolean isNewCustomer = false;

            // find out if customer exists
            sql = "SELECT ID FROM Customer " +
                    "WHERE emailAddress = " + emailAddress + ";";
            rs = stmt.executeQuery(sql);

            // if existing customer, get customerId
            while (rs.next()) {
                String email = rs.getString("emailAddress");
                if (emailAddress.equals(email)) {
                    customerId = Integer.parseInt(rs.getString("ID"));
                    idFound = true;
                    isNewCustomer = true;
                }
                if (idFound == true)
                    break;
            }

            // if new customer, insert into Customer table
            if (idFound == false)
            {
                isNewCustomer = true;
                sql = "INSERT INTO Customer " +
                        "(firstName, lastName, emailAddress, phoneNumber, ccType," +
                        "creditCardNumber, ccExpire, billAddress, billCity, billState, " +
                        "billZipCode, shipAddress, shipCity, shipState, shipZipCode, " +
                        "deliveryType, itemPurchase, itemSize, quantity, unitPrice, " +
                        "tax, taxTotal, total)" +
                        "VALUES (" + firstName + ", " + lastName + ", " +
                        emailAddress + ", " + phoneNumber + ", " +
                        ccType + ", " + creditCardNumber + ", " + ccExpire + ", " +
                        billAddress + ", " + billCity + ", " + billState + ", " +
                        billZipCode + ", " + shipAddress + ", " + shipCity + ", " +
                        shipState + ", " + shipZipCode + ", " +  deliveryType + ", " +
                        "" + ", " + "" + ", " + 0 + ", " +
                        0 + ", " + 0 + ", " + 0 + ", " + 0 + ")";
                //itemPurchase + ", " + itemSize + ", " + quantity + ", " +
                //unitPrice + ", " + tax + ", " + taxTotal + ", " + total + ")";
                stmt.executeUpdate(sql);
            }

            // then get customerId for use when storing into Orders table
            sql = "SELECT MAX(ID) FROM Customer";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                customerId = Integer.parseInt(rs.getString("ID"));
            }

            // insert data into Orders table
            sql = "INSERT INTO Orders (customerId) VALUES (" + customerId + ");";
            stmt.executeUpdate(sql);

            // get orderId
            int orderId = 0;    // 0 so compiler doesn't complain about initializing
            sql = "SELECT MAX(orderId) FROM Orders";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                orderId = Integer.parseInt(rs.getString("orderId"));
            }

            // get items from cart and insert into OrderDetails table
            HttpSession session = request.getSession();
            ArrayList<Cart> itemList = (ArrayList<Cart>)session.getAttribute("shoppingCart");
            for (Cart items : itemList) {
                String productId = items.getName();
                double unitPrice = 10.00;
                int quantity = items.getQty();
                double total = unitPrice * quantity;

                sql = "INSERT INTO OrderDetails (orderId, productId, unitPrice, quantity, total) " +
                        "VALUES (" + orderId + ", " + productId + ", " + unitPrice + ", " + quantity +
                        total + ");";
                stmt.executeUpdate(sql);
            }

            stmt.close();
            conn.close();
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

        // Previously-viewed items, param is the servlet name
        RequestDispatcher rd = request.getRequestDispatcher("OrderDetails");
        rd.forward(request, response);

    }

}