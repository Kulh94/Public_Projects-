package servlet;

import beans.User;
import client.Notification;
import test.TestServlet;
import client.Authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ((request.getSession().getAttribute("id") == null)) {
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            String Message = "You are alredy  logged in";
            request.setAttribute("alreadyloggedMess", Message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("mail");
        String password = request.getParameter("pass");
        User user = new User();
        user.setEmail(login);
        user.setPassword(password);

        Authentication authentic = new Authentication();
        Long id = authentic.loginUser(user);
        if (id != null) {
            request.getSession().setAttribute("id", id);
            String notify;
            Notification notification = new Notification();
            if (notification.getNotification(id) == true) {
                notify = "existNews";
                request.getSession().setAttribute("notify", notify);
            } else {
                notify = null;
                request.getSession().setAttribute("notify", notify);
            }
            String errorMessage = "Hello, you are logged in ";
            request.setAttribute("loggedInMess", errorMessage);
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            String errorMessage = "Invalid username or password";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }

        /**
         * For testing web-app
         TestServlet test = new TestServlet();
         if (user.getEmail().equals(test.getTestUser().getEmail()) && user.getPassword().equals(test.getTestUser().getPassword())) {
         request.getSession().setAttribute("login", login);
         String user1="1";
         notify="news";
         **/


    }

}


