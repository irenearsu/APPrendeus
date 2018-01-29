package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eus.ehu.adibidea.tta.apprendeus.Negocio.Emaitzak;
import eus.ehu.adibidea.tta.apprendeus.Negocio.Play;
import eus.ehu.adibidea.tta.apprendeus.Negocio.ProgressTask;
import eus.ehu.adibidea.tta.apprendeus.Negocio.Server;
import eus.ehu.adibidea.tta.apprendeus.Negocio.User;

public class UrtaroakActivity extends AppCompatActivity {

    User user;
    Play play;
    public final Server server = new Server("http://u017633.ehu.eus:28080/APPrendeus");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urtaroak);
    }

    protected void zuzendu(View view){

        user = User.getInstance("","");

        new ProgressTask<String>(this){
            @Override
            protected String work() throws Exception{
                Date date = new Date();
                play = new Play(user.getName(),5,ondo(),date.toString());
                return server.emaitzaIgo(play);
            }

            @Override
            protected void onFinish(String result){
                if(result.equals("Emaitza ondo gorde da")){
                    if(ondo()==10){
                        Toast.makeText(getApplicationContext(),"Ondo!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Menu2Activity.class);
                        //intent.putExtra(Menu2Activity.MAILA_EXTRA,2);

                        //Shared preferences
                        SharedPreferences prefs = getSharedPreferences(user.getName(),MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("PREF_MAILA",2);
                        editor.commit();

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
            Intent intent = new Intent(this,Menu2Activity.class);
            intent.putExtra(Menu2Activity.MAILA_EXTRA,2);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(), "Saiatu berriro!", Toast.LENGTH_SHORT).show();*/
    }

    protected float ondo(){

        List<Integer> erab = new ArrayList<Integer>();

        RadioButton rb1 = (RadioButton)findViewById(R.id.rb1_udazkena);
        if (rb1.isChecked())
            erab.add(0,0);
        else
            erab.add(0,4);

        RadioButton rb2 = (RadioButton)findViewById(R.id.rb2_uda);
        if(rb2.isChecked())
            erab.add(1,1);
        else
            erab.add(1,4);

        RadioButton rb3 = (RadioButton)findViewById(R.id.rb3_negua);
        if(rb3.isChecked())
            erab.add(2,2);
        else
            erab.add(2,4);

        RadioButton rb4 = (RadioButton)findViewById(R.id.rb4_udaberria);
        if(rb4.isChecked())
            erab.add(3,3);
        else
            erab.add(3,4);

        Emaitzak e = new Emaitzak();
        float ondo = e.checkresults(4,erab);

        return ondo;

    }
}
