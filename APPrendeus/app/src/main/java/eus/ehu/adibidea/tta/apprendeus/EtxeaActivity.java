package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import eus.ehu.adibidea.tta.apprendeus.Negocio.Emaitzak;

public class EtxeaActivity extends AppCompatActivity {

    public static final String SUKALDEA_EXTRA = "SUKALDEA";
    public static String SUKALDEA;
    public static final String JANGELA_EXTRA = "JANGELA";
    public static String JANGELA;
    public static final String EGONGELA_EXTRA = "EGONGELA";
    public static String EGONGELA;
    public static final String LOGELA_EXTRA = "LOGELA";
    public static String LOGELA;
    public static final String KOMUNA_EXTRA = "KOMUNA";
    public static String KOMUNA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etxea);

        this.SUKALDEA = getIntent().getStringExtra(SUKALDEA_EXTRA);
        this.JANGELA = getIntent().getStringExtra(JANGELA_EXTRA);
        this.EGONGELA = getIntent().getStringExtra(EGONGELA_EXTRA);
        this.LOGELA = getIntent().getStringExtra(LOGELA_EXTRA);
        this.KOMUNA = getIntent().getStringExtra(KOMUNA_EXTRA);

    }

    protected void Sukaldea(View view){
        Intent intent = new Intent(this,SukaldeaActivity.class);
        startActivity(intent);
    }

    protected void Egongela(View view){
        Intent intent = new Intent(this,EgongelaActivity.class);
        startActivity(intent);
    }

    protected void Jangela(View view){
        Intent intent = new Intent(this,JangelaActivity.class);
        startActivity(intent);
    }

    protected void Logela(View view){
        Intent intent = new Intent(this,LogelaActivity.class);
        startActivity(intent);
    }

    protected void Komuna(View view){
        Intent intent = new Intent(this,KomunaActivity.class);
        startActivity(intent);
    }

    protected void Zuzendu(View view){
        Intent intent = new Intent(this,Menu2Activity.class);
        int igo = 0;
        if (ondo()){
            Toast.makeText(getApplicationContext(), "Ondo!", Toast.LENGTH_SHORT).show();
            igo = 1;
            intent.putExtra(Menu2Activity.MAILA_EXTRA,igo);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(), "Saiatu berriro!", Toast.LENGTH_SHORT).show();

    }

    protected boolean ondo(){

        List<Integer> erab = new ArrayList<Integer>();

        try{

            if (this.SUKALDEA.equalsIgnoreCase("Sukaldea"))
                erab.add(0,0);
            else
                erab.add(0,5);

            if (this.EGONGELA.equalsIgnoreCase("Egongela"))
                erab.add(1,1);
            else
                erab.add(1,5);

            if (this.JANGELA.equalsIgnoreCase("Jangela"))
                erab.add(2,2);
            else
                erab.add(2,5);

            if (this.KOMUNA.equalsIgnoreCase("Komuna"))
                erab.add(3,3);
            else
                erab.add(3,5);

            if (this.LOGELA.equalsIgnoreCase("Logela"))
                erab.add(4,4);
            else
                erab.add(4,5);



        }
        catch (NullPointerException e){

            return false;
        }

        Emaitzak e = new Emaitzak();
        boolean ondo = e.checkresults(2,erab);

        return ondo;

    }
}
