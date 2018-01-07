package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import eus.ehu.adibidea.tta.apprendeus.Negocio.Emaitzak;

public class EgunakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egunak);
    }

    protected void Zuzendu(View view){

        if (Ondo()){
            Toast.makeText(getApplicationContext(), "Ondo!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,UrtaroakActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(), "Saiatu berriro!", Toast.LENGTH_SHORT).show();

    }

    protected boolean Ondo(){

        List<Integer> erab = new ArrayList<Integer>();

        try{

            erab.add(0,Integer.parseInt(((EditText) findViewById(R.id.a1)).getText().toString()));
            erab.add(1,Integer.parseInt(((EditText) findViewById(R.id.a2)).getText().toString()));
            erab.add(2,Integer.parseInt(((EditText) findViewById(R.id.a3)).getText().toString()));
            erab.add(3,Integer.parseInt(((EditText) findViewById(R.id.o1)).getText().toString()));
            erab.add(4,Integer.parseInt(((EditText) findViewById(R.id.o2)).getText().toString()));
            erab.add(5,Integer.parseInt(((EditText) findViewById(R.id.l)).getText().toString()));
            erab.add(6,Integer.parseInt(((EditText) findViewById(R.id.i)).getText().toString()));

        }
        catch (NumberFormatException e){

            return false;
        }

        Emaitzak e = new Emaitzak();
        boolean ondo = e.checkresults(3,erab);

        return ondo;
    }
}
