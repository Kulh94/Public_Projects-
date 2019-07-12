package servlet;

import beans.User;
import client.Authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if ((request.getSession().getAttribute("id") == null)) {
            request.getRequestDispatcher("registration.jsp").include(request, response);
        } else {
            String Message = "You have already an account";
            request.setAttribute("alreadyloggedMess", Message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("Name");
        String lastName = request.getParameter("Surname");
        String pass = request.getParameter("UserPassword");
        String email = request.getParameter("Email");
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(pass);
        Authentication authentic = new Authentication();

        if (authentic.registerUser(user) != null) {
            String okMessage = "You created a new account";
            request.setAttribute("okMessage", okMessage);
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            String errorMessage = "Invalid entered data";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }

    }

}
