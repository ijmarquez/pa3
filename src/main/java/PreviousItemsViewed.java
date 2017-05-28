import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        /*ItemModel itemModel = new ItemModel();
        itemModel.setId(Integer.parseInt(request.getParameter("ID")));
        itemModel.setGeneralName(request.getParameter("generalName"));
        itemModel.setProduct(request.getParameter("product"));
        itemModel.setCost(Double.parseDouble(request.getParameter("cost")));
        itemModel.setDescription("description");
        itemModel.setImageLocation("imageLocation");*/

        String name = request.getParameter("generalName");
        String url = request.getParameter("imageLocation");
        List<Item> itemsViewedList = new ArrayList<Item>();

        HttpSession session = request.getSession(true);
        //session.setAttribute("item", itemModel);



        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}
