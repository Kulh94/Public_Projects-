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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ShowUserAds")
public class ShowUserAds extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ((request.getSession().getAttribute("id") != null)) {
            AdsClient ads = new AdsClient();
            Long id = (Long) request.getSession().getAttribute("id");
            ArrayList<Advertisement> userAds = ads.getUserAds(id);
            /**
             * For testing servlet communication
             TestServlet forTesting= new TestServlet();
             ArrayList<Advertisement> userAds=forTesting.getUserTestList();
             **/
            String notify;
            Notification notification = new Notification();
            if (notification.getNotification(id) == true) {
                notify = "existNews";
                request.getSession().setAttribute("notify", notify);
            } else {
                notify = null;
                request.getSession().setAttribute("notify", notify);
            }

            if (userAds != null) {
                request.setAttribute("userList", userAds);
                request.getRequestDispatcher("userAccount.jsp").forward(request, response);
            } else {
                String errorMessage = "No items to show";
                request.setAttribute("NoItemsMessage", errorMessage);
                request.getRequestDispatcher("userAccount.jsp").forward(request, response);
            }

        } else {
            String errorMessage = "You are not logged in";
            request.setAttribute("notLoggetMess", errorMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

}