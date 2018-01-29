package eus.ehu.adibidea.tta.apprendeus.Vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

import eus.ehu.adibidea.tta.apprendeus.R;

public class SukaldeaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_sukaldea);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.7));
    }



    protected void Gorde(View view){

        try{

            EtxeaActivity.SUKALDEA = ((EditText) findViewById(R.id.sukaldea)).getText().toString();

        }
        catch (NumberFormatException e){
            EtxeaActivity.SUKALDEA = "";
        }


        /*Intent intent = new Intent(this,EtxeaActivity.class);
        intent.putExtra(EtxeaActivity.SUKALDEA_EXTRA,((EditText) findViewById(R.id.sukaldea)).getText().toString());
        startActivity(intent);*/
    }


}
