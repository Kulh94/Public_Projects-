package test;

import beans.Advertisement;
import beans.User;

import java.util.ArrayList;

public class TestServlet {
    ArrayList<Advertisement> advlist = new ArrayList<Advertisement>();
    ArrayList<Advertisement> userlist = new ArrayList<Advertisement>();

    public ArrayList<Advertisement> getTestList() {

        Advertisement obj1 = new Advertisement();

        obj1.setTitle("Wohnung");
        obj1.setDescription("bla,bla,bla");
        obj1.setPrice(130.0);
        obj1.setId(1);
        advlist.add(obj1);
        Advertisement obj2 = new Advertisement();

        obj2.setTitle("Wohnung 2 ");
        obj2.setDescription("bla,bla,bla");
        obj2.setPrice(150.0);
        obj2.setId(2);
        advlist.add(obj2);
        return advlist;
    }

    public User getTestUser() {
        User test_user = new User();
        test_user.setPassword("1234");
        test_user.setEmail("zhanat2@mail.ru");
        return test_user;
    }

    public boolean addTestAds(Advertisement advertisement) {

        userlist.add(advertisement);
        for (Advertisement a : userlist) {
            System.out.println(a);
        }
        return true;
    }

    public ArrayList<Advertisement> getUserTestList() {
        Advertisement obj1 = new Advertisement();

        obj1.setTitle(" new Wohnung");
        obj1.setDescription("Diese renovierte Parterre-Wohnung wird auf 5 Jahre befristet vermietet.\n" +
                "Sie besteht aus einem Vorraum, einer weißen Einbauküche mit Platz für einen Esstisch, einem geräumigen Wohnzimmer, einem Arbeits- oder Kinderzimmer mit großem " +
                "Einbauschrank, einem Schlafzimmer inkl. begehbarem Schrankraum und Bad/WC mit Duschkabine und Anschluss für eine Waschmaschine.");
        obj1.setPrice(130.0);
        obj1.setId(1);
        userlist.add(obj1);
        Advertisement obj2 = new Advertisement();

        obj2.setTitle("user Wohnung 2 ");
        obj2.setDescription("bla,bla,bla");
        obj2.setPrice(150.0);
        obj2.setId(2);
        userlist.add(obj2);

        return userlist;
    }

}
