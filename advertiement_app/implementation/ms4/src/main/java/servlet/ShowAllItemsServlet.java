package servlet;

import beans.Advertisement;
import client.AdsClient;
import test.TestServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowAllItemsServlet")
public class ShowAllItemsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AdsClient ads = new AdsClient();
        List<Advertisement> adslist = ads.getAllAds();
        /**
         * For testing servlet communication
         TestServlet forTesting= new TestServlet();
         List<Advertisement> adslist=forTesting.getTestList();
         **/
        if (adslist != null) {
            request.setAttribute("mylist", adslist);
            request.getRequestDispatcher("items.jsp").forward(request, response);
        } else {
            String errorMessage = "No items to show";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("items.jsp").forward(request, response);
        }
    }

}
