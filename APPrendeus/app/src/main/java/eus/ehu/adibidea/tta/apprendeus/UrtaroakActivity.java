package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import eus.ehu.adibidea.tta.apprendeus.Negocio.Emaitzak;

public class UrtaroakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urtaroak);
    }

    protected void zuzendu(View view){

        if(ondo()){
            Toast.makeText(getApplicationContext(), "Ondo!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Menu2Activity.class);
            intent.putExtra(Menu2Activity.MAILA_EXTRA,2);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(), "Saiatu berriro!", Toast.LENGTH_SHORT).show();
    }

    protected boolean ondo(){

        List<Integer> erab = new ArrayList<Integer>();

        RadioButton rb1 = (RadioButton)findViewById(R.id.rb1_udazkena);
        if (rb1.isChecked())
            erab.add(0,0);
        else
            erab.add(0,4);

        RadioButton rb2 = (RadioButton)findViewById(R.id.rb2_uda);
        if(rb2.isChecked())
            erab.add(1,1);
        else
            erab.add(1,4);

        RadioButton rb3 = (RadioButton)findViewById(R.id.rb3_negua);
        if(rb3.isChecked())
            erab.add(2,2);
        else
            erab.add(2,4);

        RadioButton rb4 = (RadioButton)findViewById(R.id.rb4_udaberria);
        if(rb4.isChecked())
            erab.add(3,3);
        else
            erab.add(3,4);

        Emaitzak e = new Emaitzak();
        boolean ondo = e.checkresults(4,erab);

        return ondo;

    }
}
