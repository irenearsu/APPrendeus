package eus.ehu.adibidea.tta.apprendeus.Negocio;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by tta on 1/21/18.
 */

public class Server {

    private RestClient restClient;

    public Server(String url){
        restClient = new RestClient(url);
    }

    public String logIn(User user) throws JSONException, IOException {
        JSONObject json = new JSONObject();
        json.put("name",user.getName());
        json.put("password",user.getPassword());
        return restClient.postJson(json,"rest/School/login");
    }
}