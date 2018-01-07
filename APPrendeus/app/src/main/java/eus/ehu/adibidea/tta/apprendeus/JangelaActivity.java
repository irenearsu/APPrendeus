package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

public class JangelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jangela);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));
    }

    protected void Gorde(View view){

        try{

            EtxeaActivity.JANGELA = ((EditText) findViewById(R.id.jangela)).getText().toString();
        }
        catch (NumberFormatException n){

            EtxeaActivity.JANGELA = "";
        }

        /*Intent intent = new Intent(this,EtxeaActivity.class);
        intent.putExtra(EtxeaActivity.JANGELA_EXTRA,((EditText) findViewById(R.id.jangela)).getText().toString());
        startActivity(intent);*/
    }
}
