package client;

import beans.Advertisement;
import beans.User;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


import javax.swing.text.html.parser.Entity;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

public class AdsClient {
    private String URL_editAds = "http://10.101.111.17:8080/app/update";
    private String URL_getAllAds = "http://10.101.111.17:8080/app/advertisements";
    private String URL_getUserAds = "http://10.101.111.17:8080/app/userad";
    private String URL_addAds = "http://10.101.111.17:8080/app/add/advertisement";
    private String URL_deleteAds = "http://10.101.111.17:8080/app/delete/advertisement";


    public boolean editAds(Advertisement ads, Long id) {

        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResourcePost = client.resource(URL_editAds + "/" + id);
        ClientResponse response = webResourcePost.accept("application/json").type("application/json").put(ClientResponse.class, ads);
        if (response.getStatus() != 200)
            return false;
        return true;
    }

    public ArrayList<Advertisement> getAllAds() {
        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource resource = client.resource(URL_getAllAds);
        ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200)
            return null;
        //source https://stackoverflow.com/questions/36338157/get-arraylist-in-restful-jersy-client
        ArrayList<Advertisement> listAds = response.getEntity(new GenericType<ArrayList<Advertisement>>() {
        });
        return listAds;
    }


    public ArrayList<Advertisement> getUserAds(Long id) {
        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource resource = client.resource(URL_getUserAds + "/" + id);
        ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200)
            return null;
        ArrayList<Advertisement> UserAdsList = response.getEntity(new GenericType<ArrayList<Advertisement>>() {
        });
        return UserAdsList;
    }

    public boolean addNewAds(Advertisement ads, Long id) {

        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResourcePost = client.resource(URL_addAds + "/" + id);
        ClientResponse response = webResourcePost.accept("application/json").type("application/json").post(ClientResponse.class, ads);
        if (response.getStatus() != 200)
            return false;
        else
            return true;
    }

    public boolean deleteAds(Integer id) {

        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResourcePost = client.resource(URL_deleteAds + "/" + id);
        ClientResponse response = webResourcePost.delete(ClientResponse.class);
        if (response.getStatus() != 200)
            return false;
        return true;
    }

}

