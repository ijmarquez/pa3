import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by irishmarquez on 5/26/17.
 */
@WebServlet(name = "PreviousItemsViewed")
public class PreviousItemsViewed extends HttpServlet {
 //   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //   }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //DB information
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = Constants.getDatabaseName();
        final String DB_USER = Constants.getUsername();
        final String DB_PASS = Constants.getPassword();

        Connection conn = null;
        //Statement stmt = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // access viewedList through session
        HttpSession session = request.getSession();

        //create a list to handle viewedList from session
        List<ItemModel> viewedList = (ArrayList)session.getAttribute("viewedList");
        if (viewedList == null)                                          // <------- delete later
            out.println("<p>ViewedList null</p>");
        else
            out.println("<p>size = " + viewedList.size() + "</p>");

        // output of PreviousItemsViewed servlet
        out.println("<div class='items-viewed-container'>");
        out.println("<div class='items-viewed'>");
        out.println("<p>Items Viewed:</p>");

        if (viewedList == null)
        {
            out.println("<p>No items previously viewed.</p>");
        }
        else
        {
            try
            {
                // connect to DB
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                //stmt = conn.createStatement();

                out.println("<p>Inside Try block</p>");                 // <----------- delete later
                out.println("<table>");
                out.println("<tr>");
                for (int i = 0; i < viewedList.size(); ++i) {
                    out.println("<td>");

                    // get item at index i from viewedList
                    ItemModel it = new ItemModel();
                    it = viewedList.get(i);
                    String genName = it.getGeneralName();
                    String url = null;

                    String prepStmtString =
                            "SELECT `imageLocation` FROM `MainProduct` " +  //<------ added ` `
                                    "WHERE `generalName` = ?";

                    // use prepared statement so we can use user input in sql query
                    prepStmt = conn.prepareStatement(prepStmtString);

                    // replace ? in prepStmtString and store query result in rs
                    prepStmt.setString(1, genName);
                    rs = prepStmt.executeQuery();

                    url = rs.getString("imageLocation");

                    // uses genName and url for href
                    out.println("<a href=\"Item?product='" + genName + "'&amp;image='" + url + "'\">");
                    out.println("<img class=\"image_thumbnail\" src= \"" + url + "\" alt= \"" + genName + ">");
                    out.println("</td>");
                }
                //rs.close();
                //prepStmt.close();
                //conn.close();

                out.println("</tr>");
                out.println("</table>");


                out.println("</div>"); // items-viewed
                out.println("</div>"); // items-viewed-container
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
            /*finally
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
            }*/

        }   // end else
    } // end doGet
}   // end class




//        else
//        {
//            out.println("<table>");
//            out.println("<tr>");
//            for (int i = 0; i < viewedList.size(); ++i)
//            {
//                out.println("<td>");
//
//                // get item at index i from viewedList
//                ItemModel it = new ItemModel();
//                it = viewedList.get(i);
//                String genName = it.getGeneralName();
//                String url = it.getImageLocation();
//
//                // uses genName and url for href
//                out.println("<a href=\"Item?product='" + genName + "'&amp;image='" + url + "'\">");
//                out.println("<img class=\"image_thumbnail\" src= \""+ url +"\" alt= \""+ genName+">");
//                out.println("</td>");
//            }
//            out.println("</tr>");
//            out.println("</table>");
//
//
//            out.println("</div>"); // items-viewed
//            out.println("</div>"); // items-viewed-container
//        }



