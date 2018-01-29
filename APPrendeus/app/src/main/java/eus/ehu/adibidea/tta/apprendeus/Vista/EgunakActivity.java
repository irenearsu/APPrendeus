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

public class EgunakActivity extends AppCompatActivity {

    User user;
    Play play;
    public final Server server = new Server("http://u017633.ehu.eus:28080/APPrendeus");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egunak);
    }

    protected void Zuzendu(View view){

        user = User.getInstance("","");

        new ProgressTask<String>(this){
            @Override
            protected String work() throws Exception{
                Date date = new Date();
                play = new Play(user.getName(),4,ondo(),date.toString());
                return server.emaitzaIgo(play);
            }

            @Override
            protected void onFinish(String result){
                if(result.equals("Emaitza ondo gorde da")){
                    if(ondo()==10){
                        Toast.makeText(getApplicationContext(),"Ondo!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),UrtaroakActivity.class);
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

        /*if (Ondo()){
            Toast.makeText(getApplicationContext(), "Ondo!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,UrtaroakActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(), "Saiatu berriro!", Toast.LENGTH_SHORT).show();*/

    }

    protected float ondo(){

        List<Integer> erab = new ArrayList<Integer>();

        try{

            erab.add(0,Integer.parseInt(((EditText) findViewById(R.id.a1)).getText().toString()));
            erab.add(1,Integer.parseInt(((EditText) findViewById(R.id.a2)).getText().toString()));
            erab.add(2,Integer.parseInt(((EditText) findViewById(R.id.a3)).getText().toString()));
            erab.add(3,Integer.parseInt(((EditText) findViewById(R.id.o1)).getText().toString()));
            erab.add(4,Integer.parseInt(((EditText) findViewById(R.id.o2)).getText().toString()));
            erab.add(5,Integer.parseInt(((EditText) findViewById(R.id.l)).getText().toString()));
            erab.add(6,Integer.parseInt(((EditText) findViewById(R.id.i)).getText().toString()));

        }
        catch (NumberFormatException e){

            return 0;
        }

        Emaitzak e = new Emaitzak();
        float ondo = e.checkresults(3,erab);

        return ondo;
    }
}
