package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

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

    protected void Atzera(View view){
        Intent intent = new Intent(this,EtxeaActivity.class);
        intent.putExtra(EtxeaActivity.SUKALDEA_EXTRA,((EditText) findViewById(R.id.sukaldea)).getText().toString());
        startActivity(intent);
    }


}
