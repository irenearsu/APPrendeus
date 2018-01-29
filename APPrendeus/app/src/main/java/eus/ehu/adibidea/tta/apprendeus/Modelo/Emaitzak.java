package eus.ehu.adibidea.tta.apprendeus.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tta on 1/5/18.
 */

public class Emaitzak {

    private final List<Integer> GORPUTZA;
    private final List<Integer> FAMILIA;
    private final List<Integer> ETXEA;
    private final List<Integer> EGUNAK;
    private final List<Integer> URTAROAK;

    public Emaitzak(){

        GORPUTZA = new ArrayList<Integer>();
        GORPUTZA.add(0,1);
        GORPUTZA.add(1,7);
        GORPUTZA.add(2,5);
        GORPUTZA.add(3,2);
        GORPUTZA.add(4,4);
        GORPUTZA.add(5,6);
        GORPUTZA.add(6,3);

        FAMILIA = new ArrayList<Integer>();
        FAMILIA.add(0,0);
        FAMILIA.add(1,1);
        FAMILIA.add(2,2);
        FAMILIA.add(3,3);

        ETXEA = new ArrayList<Integer>();
        ETXEA.add(0,0);
        ETXEA.add(1,1);
        ETXEA.add(2,2);
        ETXEA.add(3,3);
        ETXEA.add(4,4);

        EGUNAK = new ArrayList<Integer>();
        EGUNAK.add(0,3);
        EGUNAK.add(1,1);
        EGUNAK.add(2,6);
        EGUNAK.add(3,2);
        EGUNAK.add(4,5);
        EGUNAK.add(5,4);
        EGUNAK.add(6,7);

        URTAROAK = new ArrayList<Integer>();
        URTAROAK.add(0,0);
        URTAROAK.add(1,1);
        URTAROAK.add(2,2);
        URTAROAK.add(3,3);
    }

    public float checkresults(int jokua, List<Integer> erab){

        float ondo = 0;

        String erabs = erab.toString();


        switch(jokua){
            case 0:
                String gorputzas = GORPUTZA.toString();
                if(gorputzas.equals(erabs))
                     ondo=10;
                break;
            case 1:
                String familias = FAMILIA.toString();
                if(familias.equals(erabs))
                    ondo=10;
                break;
            case 2:
                String etxeas = ETXEA.toString();
                if(etxeas.equals(erabs))
                    ondo=10;
                break;
            case 3:
                String egunaks = EGUNAK.toString();
                if(egunaks.equals(erabs))
                    ondo=10;
                break;
            case 4:
                String urtaroaks = URTAROAK.toString();
                if(urtaroaks.equals(erabs))
                    ondo=10;
                break;

        }

        return ondo;
    }

}
