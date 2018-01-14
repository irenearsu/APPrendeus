package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu2Activity extends AppCompatActivity {

    public static final String MAILA_EXTRA = "MAILA";
    public int MAILA = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        this.MAILA = getIntent().getIntExtra(MAILA_EXTRA,0);

        switch (MAILA){
            case 0:
                //findViewById(R.id.button3).setEnabled(true);
                break;
            case 1:
                findViewById(R.id.button2).setEnabled(true);
                break;
            case 2:
                findViewById(R.id.button2).setEnabled(true);
                findViewById(R.id.button3).setEnabled(true);
                break;
        }

    }

    public void maila1(View view){
        Intent intent = new Intent(this,GorputzaActivity.class);
        startActivity(intent);
    }

    public void maila2(View view){
        Intent intent = new Intent(this,EgunakActivity.class);
        startActivity(intent);
    }

    public void maila3(View view){
        Intent intent = new Intent(this,BingoaActivity.class);
        startActivity(intent);
    }
}
