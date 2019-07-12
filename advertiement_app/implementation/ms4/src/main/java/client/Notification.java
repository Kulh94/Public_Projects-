package client;

import beans.Advertisement;
import beans.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import java.util.ArrayList;

public class Notification {
    private String URL_search = "http://10.101.111.9:8080/search";
    private String URL_UserSearch = "http://10.101.111.9:8080/search";
    private String URL_notifyList = "http://10.101.111.9:8080/notifications/";
    private String URL_notify = "http://10.101.111.9:8080/proof/notifications/";

    public ArrayList<Advertisement> getFoundAds(String keyword) {
        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource resource = client.resource(URL_search + "/" + keyword);
        ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
        ArrayList<Advertisement> foundAds = response.getEntity(new GenericType<ArrayList<Advertisement>>() {
        });
        return foundAds;
    }

    public ArrayList<Advertisement> getUserFoundAds(String keyword, Long id) {
        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource resource = client.resource(URL_UserSearch + "/" + id + "/" + keyword);
        ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
        ArrayList<Advertisement> foundAds = response.getEntity(new GenericType<ArrayList<Advertisement>>() {
        });
        return foundAds;
    }

    public boolean getNotification(Long id) {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource resource = client.resource(URL_notify + id);
        ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
        if (response.getEntity(boolean.class) == true)
            return true;
        else return false;
    }

    public ArrayList<Advertisement> getNotifList(Long id) {
        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource resource = client.resource(URL_notifyList + id);
        ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
        ArrayList<Advertisement> newdAds = response.getEntity(new GenericType<ArrayList<Advertisement>>() {
        });
        return newdAds;
    }


}
