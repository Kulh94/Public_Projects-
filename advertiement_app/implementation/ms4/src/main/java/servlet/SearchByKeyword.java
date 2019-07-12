package servlet;

import beans.Advertisement;
import client.AdsClient;
import client.Notification;
import test.TestServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SearchByKeyword")
public class SearchByKeyword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("id") != null) {
            String keyword = request.getParameter("keyword");
            Notification notification = new Notification();
            Long id = (Long) request.getSession().getAttribute("id");
            ArrayList<Advertisement> foundAdsList = notification.getUserFoundAds(keyword, id);
            if (foundAdsList != null) {
                request.setAttribute("searchList", foundAdsList);
                request.getRequestDispatcher("foundItems.jsp").forward(request, response);
            } else {
                String errorMessage = "No items to show";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("foundItems.jsp").forward(request, response);
            }

        } else {
            String keyword = request.getParameter("keyword");
            Notification notification = new Notification();
            ArrayList<Advertisement> foundAdsList = notification.getFoundAds(keyword);
            if (foundAdsList != null) {
                request.setAttribute("searchList", foundAdsList);
                request.getRequestDispatcher("foundItems.jsp").forward(request, response);
            } else {
                String errorMessage = "No items to show";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("foundItems.jsp").forward(request, response);
            }
        }

    }
}
