package eus.ehu.adibidea.tta.apprendeus.Negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tta on 1/5/18.
 */

public class Emaitzak {

    private final List<Integer> gorputza;
    private final List<Integer> familia;
    private final List<Integer> ETXEA;

    public Emaitzak(){

        gorputza = new ArrayList<Integer>();
        gorputza.add(0,1);
        gorputza.add(1,7);
        gorputza.add(2,5);
        gorputza.add(3,2);
        gorputza.add(4,4);
        gorputza.add(5,6);
        gorputza.add(6,3);

        familia = new ArrayList<Integer>();
        familia.add(0,0);
        familia.add(1,1);
        familia.add(2,2);
        familia.add(3,3);

        ETXEA = new ArrayList<Integer>();
        ETXEA.add(0,0);
        ETXEA.add(1,1);
        ETXEA.add(2,2);
        ETXEA.add(3,3);
        ETXEA.add(4,4);
    }

    public boolean checkresults(int jokua, List<Integer> erab){

        boolean ondo = false;

        switch(jokua){
            case 0:
                if(gorputza.containsAll(erab))
                     ondo=true;
                else
                    ondo=false;
                break;
            case 1:
                if(familia.containsAll(erab))
                    ondo=true;
                else
                    ondo=false;
                break;
            case 2:
                if(ETXEA.containsAll(erab))
                    ondo=true;
                else
                    ondo=false;
                break;
        }

        return ondo;
    }

}
