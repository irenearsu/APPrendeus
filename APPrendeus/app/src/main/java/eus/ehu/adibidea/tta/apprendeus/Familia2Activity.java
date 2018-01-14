package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import eus.ehu.adibidea.tta.apprendeus.Negocio.Emaitzak;

public class Familia2Activity extends AppCompatActivity {

    public static final String FAMILIA_EXTRA1 = "FAMILIA1";
    public String FAMILIA1;
    public static final String FAMILIA_EXTRA2 = "FAMILIA2";
    public String FAMILIA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familia2);

        this.FAMILIA1 = getIntent().getStringExtra(FAMILIA_EXTRA1);
        this.FAMILIA2 = getIntent().getStringExtra(FAMILIA_EXTRA2);

    }

    protected void zuzendu(View view){

        if(ondo()){
            Toast.makeText(getApplicationContext(), "Ondo!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,EtxeaActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(), "Saiatu berriro!", Toast.LENGTH_SHORT).show();


    }

    protected boolean ondo(){

        List<Integer> erab = new ArrayList<Integer>();

        try{

            if (this.FAMILIA1.equalsIgnoreCase("Ahizpa"))
                erab.add(0,0);
            else
                erab.add(0,4);

            if (this.FAMILIA2.equalsIgnoreCase("Neba"))
                erab.add(1,1);
            else
                erab.add(1,4);

            if (((EditText) findViewById(R.id.familia3)).getText().toString().equalsIgnoreCase("Arreba"))
                erab.add(2,2);
            else
                erab.add(2,4);

            if (((EditText) findViewById(R.id.familia4)).getText().toString().equalsIgnoreCase("Anaia"))
                erab.add(3,3);
            else
                erab.add(3,4);



        }
        catch (NumberFormatException e){

            return false;
        }

        Emaitzak e = new Emaitzak();
        boolean ondo = e.checkresults(1,erab);

        return ondo;

    }
}
