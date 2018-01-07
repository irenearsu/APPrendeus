package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

public class LogelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logela);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));
    }

    protected void Gorde(View view){

        try{

            EtxeaActivity.LOGELA = ((EditText) findViewById(R.id.logela)).getText().toString();

        }
        catch (NumberFormatException e){

            EtxeaActivity.LOGELA = "";
        }



        /*Intent intent = new Intent(this,EtxeaActivity.class);
        intent.putExtra(EtxeaActivity.LOGELA_EXTRA,((EditText) findViewById(R.id.logela)).getText().toString());
        startActivity(intent);*/
    }
}
