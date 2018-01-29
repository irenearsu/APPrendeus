package eus.ehu.adibidea.tta.apprendeus.Vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class Familia2Activity extends AppCompatActivity {

    public static final String FAMILIA_EXTRA1 = "FAMILIA1";
    public String FAMILIA1;
    public static final String FAMILIA_EXTRA2 = "FAMILIA2";
    public String FAMILIA2;

    User user;
    Play play;
    public final Server server = new Server("http://u017633.ehu.eus:28080/APPrendeus");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familia2);

        this.FAMILIA1 = getIntent().getStringExtra(FAMILIA_EXTRA1);
        this.FAMILIA2 = getIntent().getStringExtra(FAMILIA_EXTRA2);

    }

    protected void zuzendu(View view){

        user = User.getInstance("","");

        new ProgressTask<String>(this){
            @Override
            protected String work() throws Exception{
                Date date = new Date();
                play = new Play(user.getName(),2,ondo(),date.toString());
                return server.emaitzaIgo(play);
            }

            @Override
            protected void onFinish(String result){
                if(result.equals("Emaitza ondo gorde da")){
                    if(ondo()==10){
                        Toast.makeText(getApplicationContext(),"Ondo!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),EtxeaActivity.class);
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

        /*if(ondo()){
            Toast.makeText(getApplicationContext(), "Ondo!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,EtxeaActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(), "Saiatu berriro!", Toast.LENGTH_SHORT).show();*/


    }

    protected float ondo(){

        List<Integer> erab = new ArrayList<Integer>();

        try{

            if (this.FAMILIA1.equalsIgnoreCase("Ahizpa"))
                erab.add(0,0);
            else
                erab.add(0,4);

            if (this.FAMILIA2.equalsIgnoreCase("Neba"))
                erab.add(1,1);
            else
                erab.add(1,4);

            if (((EditText) findViewById(R.id.familia3)).getText().toString().equalsIgnoreCase("Arreba"))
                erab.add(2,2);
            else
                erab.add(2,4);

            if (((EditText) findViewById(R.id.familia4)).getText().toString().equalsIgnoreCase("Anaia"))
                erab.add(3,3);
            else
                erab.add(3,4);



        }
        catch (NumberFormatException e){

            return 0;
        }

        Emaitzak e = new Emaitzak();
        float ondo = e.checkresults(1,erab);

        return ondo;

    }
}
