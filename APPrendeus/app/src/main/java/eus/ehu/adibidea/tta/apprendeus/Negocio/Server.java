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

    public String signIn(User user) throws JSONException,IOException{
        JSONObject json = new JSONObject();
        json.put("name",user.getName());
        json.put("password",user.getPassword());
        return restClient.postJson(json,"rest/School/addStudent");
    }

    public String emaitzaIgo(Play play) throws JSONException,IOException{
        JSONObject json = new JSONObject();
        json.put("name",play.getName());
        json.put("idgame",play.getIdGame());
        json.put("note",play.getNote());
        json.put("date",play.getDate());
        return restClient.postJson(json,"rest/School/play");
    }
}
