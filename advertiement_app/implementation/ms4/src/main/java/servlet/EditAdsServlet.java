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

@WebServlet("/EditAdsServlet")
public class EditAdsServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer adsId = Integer.parseInt(request.getParameter("Adsid"));
        Advertisement ads = new Advertisement();
        /**
         * For testing web-app
         TestServlet forTesting= new TestServlet();
         ArrayList<Advertisement> userlist = forTesting.getUserTestList();
         Long userId1="1";
         Long userId2="2";
         **/
        Long id = (Long) request.getSession().getAttribute("id");
        AdsClient adsClient = new AdsClient();
        ArrayList<Advertisement> userlist = adsClient.getUserAds(id);

        for (Advertisement advertisement : userlist) {
            if (adsId.equals(advertisement.getId()))
                ads = advertisement;
        }
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("editAds.jsp").include(request, response);

    }
}
