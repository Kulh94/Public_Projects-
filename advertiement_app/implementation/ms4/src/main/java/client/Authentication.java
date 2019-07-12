package client;

// source: http://buraktas.com/jersey-client-example-with-json-support/

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import beans.User;

public class Authentication {
    private String URL_login = "http://10.101.111.13:8094/ms1/login";
    private String URL_registerUser = "http://10.101.111.13:8094/ms1/register";
    private String URL_checkUser = "http://10.101.111.13:8050";


    public Long loginUser(User user) {
        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResourcePost = client.resource(URL_login);
        ClientResponse response = webResourcePost.accept("application/json").type("application/json").post(ClientResponse.class, user);
        if (response.getStatus() != 200)
            return null;
        Long id = response.getEntity(long.class);
        return id;
    }

    public User registerUser(User user) {
        // Create Jersey client
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResourcePost = client.resource(URL_registerUser);
        ClientResponse response = webResourcePost.accept("application/json").type("application/json").post(ClientResponse.class, user);
        if (response.getStatus() != 200)
            return null;
        User createdUser = response.getEntity(User.class);
        return createdUser;
    }


}
