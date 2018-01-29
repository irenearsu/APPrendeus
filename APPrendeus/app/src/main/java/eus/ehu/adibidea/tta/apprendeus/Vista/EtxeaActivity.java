package eus.ehu.adibidea.tta.apprendeus.Vista;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eus.ehu.adibidea.tta.apprendeus.Modelo.Emaitzak;
import eus.ehu.adibidea.tta.apprendeus.Modelo.Play;
import eus.ehu.adibidea.tta.apprendeus.Modelo.ProgressTask;
import eus.ehu.adibidea.tta.apprendeus.Modelo.Server;
import eus.ehu.adibidea.tta.apprendeus.Modelo.User;
import eus.ehu.adibidea.tta.apprendeus.R;

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

    User user;
    Play play;
    public final Server server = new Server("http://u017633.ehu.eus:28080/APPrendeus");

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

        user = User.getInstance("","");

        new ProgressTask<String>(this){
            @Override
            protected String work() throws Exception{
                Date date = new Date();
                play = new Play(user.getName(),3,ondo(),date.toString());
                return server.emaitzaIgo(play);
            }

            @Override
            protected void onFinish(String result){
                if(result.equals("Emaitza ondo gorde da")){
                    if(ondo()==10){
                        Toast.makeText(getApplicationContext(),"Ondo!", Toast.LENGTH_SHORT).show();
                        //intent.putExtra(Menu2Activity.MAILA_EXTRA,1);


                        //Shared preferences
                        SharedPreferences prefs = getSharedPreferences(user.getName(),MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("PREF_MAILA",1);
                        editor.commit();

                        Intent intent = new Intent(getApplicationContext(),Menu2Activity.class);
                        startActivity(intent);

                    }
                    else
                        Toast.makeText(getApplicationContext(),"Saiatu berriro..", Toast.LENGTH_SHORT).show();


                }
                else if (result.equals("Emaitza ez da gorde")){
                    Toast.makeText(getApplicationContext(),"Ez da emaitza gorde", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(getApplicationContext(),"KX ez", Toast.LENGTH_SHORT).show();

            }

        }.execute();

        /*if (ondo()){
            Toast.makeText(getApplicationContext(), "Ondo!", Toast.LENGTH_SHORT).show();
            igo = 1;
            intent.putExtra(Menu2Activity.MAILA_EXTRA,igo);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(), "Saiatu berriro!", Toast.LENGTH_SHORT).show();*/

    }

    protected float ondo(){

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

            return 0;
        }

        Emaitzak e = new Emaitzak();
        float ondo = e.checkresults(2,erab);

        return ondo;

    }
}
