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

@WebServlet("/NotificationServlet")
public class NotificationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ((request.getSession().getAttribute("id") != null)) {
            Notification notification = new Notification();
            Long id = (Long) request.getSession().getAttribute("id");
            ArrayList<Advertisement> userAds = notification.getNotifList(id);
            /**
             * For testing servlet communication
             TestServlet forTesting= new TestServlet();
             ArrayList<Advertisement> userAds=forTesting.getUserTestList();
             **/
            if (userAds != null) {
                request.setAttribute("userList", userAds);
                request.getRequestDispatcher("notifyList.jsp").forward(request, response);
            } else {
                String errorMessage = "No items to show";
                request.setAttribute("errorMessage", errorMessage);
            }

        } else {
            String errorMessage = "You are not logged in";
            request.setAttribute("notLoggetMess", errorMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
}
