package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

public class EgongelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egongela);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));
    }

    protected void Gorde(View view){

        try{

            EtxeaActivity.EGONGELA = ((EditText) findViewById(R.id.egongela)).getText().toString();
        }
        catch(NumberFormatException n){

            EtxeaActivity.EGONGELA = "";
        }


        /*Intent intent = new Intent(this,EtxeaActivity.class);
        intent.putExtra(EtxeaActivity.EGONGELA_EXTRA,((EditText) findViewById(R.id.egongela)).getText().toString());
        startActivity(intent);*/
    }
}
