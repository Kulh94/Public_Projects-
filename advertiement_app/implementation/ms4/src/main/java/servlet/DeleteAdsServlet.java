package servlet;

import beans.Advertisement;
import client.AdsClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DeleteAdsServlet")
public class DeleteAdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer adsId = Integer.parseInt(request.getParameter("Adsid"));
        /**
         * For Web-app Testing
         TestServlet forTesting= new TestServlet();
         ArrayList<Advertisement> userlist = forTesting.getUserTestList();
         **/
        Advertisement ads = new Advertisement();
        AdsClient adsClient = new AdsClient();
        Long id = (Long) request.getSession().getAttribute("id");
        ArrayList<Advertisement> userlist = adsClient.getUserAds(id);

        for (Advertisement advertisement : userlist) {
            if (id.equals(advertisement.getId()))
                ads = advertisement;
        }

        boolean deleted = adsClient.deleteAds(adsId);
        if (deleted == true) {
            String deleteMess = "Advertisement deleted";
            request.setAttribute("deleteMess", deleteMess);
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            String errorDeleteAdsMess = "Not possible to delete";
            request.setAttribute("errorEditAdsMess", errorDeleteAdsMess);
            request.getRequestDispatcher("userAccount.jsp").forward(request, response);

        }

    }

}
