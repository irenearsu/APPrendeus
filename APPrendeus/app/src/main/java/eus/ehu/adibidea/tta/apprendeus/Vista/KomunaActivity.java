package eus.ehu.adibidea.tta.apprendeus.Vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

import eus.ehu.adibidea.tta.apprendeus.R;

public class KomunaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komuna);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));
    }

    protected void Gorde(View view){

        try{

            EtxeaActivity.KOMUNA = ((EditText) findViewById(R.id.komuna)).getText().toString();
        }
        catch(NumberFormatException n){

            EtxeaActivity.KOMUNA = "";
        }


        /*Intent intent = new Intent(this,EtxeaActivity.class);
        intent.putExtra(EtxeaActivity.KOMUNA_EXTRA,((EditText) findViewById(R.id.komuna)).getText().toString());
        startActivity(intent);*/
    }
}
