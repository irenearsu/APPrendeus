package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FamiliaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familia);
    }

    public void Hurrengoa(View view){
        Intent intent = new Intent(this,Familia2Activity.class);
        intent.putExtra(Familia2Activity.FAMILIA_EXTRA1,((EditText) findViewById(R.id.familia1)).getText().toString());
        intent.putExtra(Familia2Activity.FAMILIA_EXTRA2,((EditText) findViewById(R.id.familia2)).getText().toString());
        startActivity(intent);
    }
}
