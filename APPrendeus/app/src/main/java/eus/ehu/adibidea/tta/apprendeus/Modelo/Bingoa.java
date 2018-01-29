package eus.ehu.adibidea.tta.apprendeus.Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tta on 1/14/18.
 */

public class Bingoa {

    private List<Integer> zenbakik;
    private List<String> zenbakikL;

    public Bingoa (){
        zenbakik = new ArrayList<Integer>();
        zenbakikL = new ArrayList<String>();

        zenbakik.add(1);
        zenbakik.add(2);
        zenbakik.add(3);
        zenbakik.add(4);
        zenbakik.add(5);
        zenbakik.add(6);
        zenbakik.add(7);
        zenbakik.add(8);
        zenbakik.add(9);
        zenbakik.add(10);
        zenbakik.add(11);
        zenbakik.add(12);
        zenbakik.add(13);
        zenbakik.add(14);
        zenbakik.add(15);
        zenbakik.add(16);
        zenbakik.add(17);
        zenbakik.add(18);
        zenbakik.add(19);
        zenbakik.add(20);

        zenbakikL.add("Bat");
        zenbakikL.add("Bi");
        zenbakikL.add("Hiru");
        zenbakikL.add("Lau");
        zenbakikL.add("Bost");
        zenbakikL.add("Sei");
        zenbakikL.add("Zazpi");
        zenbakikL.add("Zortzi");
        zenbakikL.add("Bederatzi");
        zenbakikL.add("Hamar");
        zenbakikL.add("Hamaika");
        zenbakikL.add("Hamabi");
        zenbakikL.add("Hamairu");
        zenbakikL.add("Hamalau");
        zenbakikL.add("Hamabost");
        zenbakikL.add("Hamasei");
        zenbakikL.add("Hamazazpi");
        zenbakikL.add("Hemezortzi");
        zenbakikL.add("Hemeretzi");
        zenbakikL.add("Hogei");

    }

    public List<Integer> shuffleInt(){

        Collections.shuffle(zenbakik);
        return zenbakik;

    }

    public List<String> shuffleString(){

        Collections.shuffle(zenbakikL);
        return zenbakikL;
    }

}
