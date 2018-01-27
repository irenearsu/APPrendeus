package eus.ehu.adibidea.tta.apprendeus.Negocio;

/**
 * Created by tta on 1/21/18.
 */

public class User {

    private String name;
    private String password;

    private static User instance = null;

    public static synchronized User getInstance(String name, String password){
        if(instance == null)
            instance = new User(name,password);
        return instance;
    }

    public User(String name, String password){
        this.name=name;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
