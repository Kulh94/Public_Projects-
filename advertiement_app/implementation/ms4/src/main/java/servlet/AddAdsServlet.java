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
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/AddAdsServlet")
public class AddAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ((request.getSession().getAttribute("id") != null)) {
            request.getRequestDispatcher("addAds.jsp").include(request, response);
        } else {
            String errorMessage = "You are not logged in";
            request.setAttribute("notLoggetMess", errorMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titel = request.getParameter("titel");
        String price = request.getParameter("price");
        String desc = request.getParameter("desc");
        String email = request.getParameter("email");
        Advertisement advertisement = new Advertisement();
        advertisement.setDescription(desc);
        advertisement.setTitle(titel);
        advertisement.setPrice(Double.parseDouble(price));
        advertisement.setEmail(email);

        AdsClient ads = new AdsClient();
        Long id = (Long) request.getSession().getAttribute("id");
        if (ads.addNewAds(advertisement, id) == true) {
            String successMessage = "your Item is successfully added to sell ";
            request.setAttribute("itemAdded", successMessage);
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            String errorMessage = "Error by posting new item";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("addAds.jsp").forward(request, response);
        }

    }

}
