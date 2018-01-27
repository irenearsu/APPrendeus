package eus.ehu.adibidea.tta.apprendeus.Negocio;

import java.util.Date;

/**
 * Created by tta on 1/27/18.
 */

public class Play {

    private String name;
    private int idGame;
    private float note;
    private String date;

    public Play(String name, int idGame, float note, String date){
        this.name=name;
        this.idGame=idGame;
        this.note=note;
        this.date=date;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public float getNote(){
        return note;
    }
}
