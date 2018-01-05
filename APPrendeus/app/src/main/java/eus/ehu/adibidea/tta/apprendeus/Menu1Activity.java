package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);
    }

    public void A1(View view){
        Intent intent = new Intent(this,Menu2Activity.class);
        startActivity(intent);
    }
}
