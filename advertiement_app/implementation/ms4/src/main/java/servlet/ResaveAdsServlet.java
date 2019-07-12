package servlet;

import beans.Advertisement;
import client.AdsClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResaveAdsServlet")
public class ResaveAdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = (Long) request.getSession().getAttribute("id");
        String titel = request.getParameter("title");
        String price = request.getParameter("price");
        String desc = request.getParameter("description");
        String email = request.getParameter("email");
        String adsId = request.getParameter("adsId");
        Advertisement advertisement = new Advertisement();
        advertisement.setDescription(desc);
        advertisement.setTitle(titel);
        advertisement.setPrice(Double.parseDouble(price));
        advertisement.setEmail(email);
        advertisement.setId(Integer.parseInt(adsId));
        AdsClient adsClient = new AdsClient();
        adsClient.editAds(advertisement, id);

        if (adsClient.editAds(advertisement, id) == true) {
            String editAdsMessage = "Your advertisment is edited";
            request.setAttribute("editAdsMessage", editAdsMessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            String errorEditAdsMess = "Not possible to edit";
            request.setAttribute("errorEditAdsMess", errorEditAdsMess);
            request.getRequestDispatcher("editAds.jsp").forward(request, response);
        }

    }

}
