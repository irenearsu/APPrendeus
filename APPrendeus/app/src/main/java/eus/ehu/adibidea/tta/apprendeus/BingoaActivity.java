package eus.ehu.adibidea.tta.apprendeus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import eus.ehu.adibidea.tta.apprendeus.Negocio.Bingoa;
import eus.ehu.adibidea.tta.apprendeus.Negocio.Play;
import eus.ehu.adibidea.tta.apprendeus.Negocio.ProgressTask;
import eus.ehu.adibidea.tta.apprendeus.Negocio.Server;
import eus.ehu.adibidea.tta.apprendeus.Negocio.User;

public class BingoaActivity extends AppCompatActivity {

    private List<Integer> zenbakik;
    private List<String> zenbakikL;
    private int i = 0;
    private int ondo = 0;

    User user;
    Play play;
    public final Server server = new Server("http://u017633.ehu.eus:28080/APPrendeus");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bingoa);

        Bingoa b = new Bingoa();
        TextView a = (TextView)findViewById(R.id.zenbaki);
        zenbakikL = b.shuffleString();
        a.setText((CharSequence) zenbakikL.get(0));

        zenbakik = b.shuffleInt();
        Button b1 = (Button)findViewById(R.id.b1);
        Button b2 = (Button)findViewById(R.id.b2);
        Button b3 = (Button)findViewById(R.id.b3);
        Button b4 = (Button)findViewById(R.id.b4);
        Button b5 = (Button)findViewById(R.id.b5);
        Button b6 = (Button)findViewById(R.id.b6);
        Button b7 = (Button)findViewById(R.id.b7);
        Button b8 = (Button)findViewById(R.id.b8);

        b1.setText(zenbakik.get(0).toString());
        b2.setText(zenbakik.get(1).toString());
        b3.setText(zenbakik.get(2).toString());
        b4.setText(zenbakik.get(3).toString());
        b5.setText(zenbakik.get(4).toString());
        b6.setText(zenbakik.get(5).toString());
        b7.setText(zenbakik.get(6).toString());
        b8.setText(zenbakik.get(7).toString());

    }

    public void hurrengoa(View view){

        i++;

        if(i<20){

            TextView a = (TextView)findViewById(R.id.zenbaki);
            a.setText((CharSequence) zenbakikL.get(i));

        }
        else{
            findViewById(R.id.hurrengoa).setEnabled(false);
            zuzendu(view);
        }


    }

    public void asmatu(View view){

        String z = "";
        int p = 0;

        switch (view.getId()){
            case (R.id.b1):
                p=0;
                break;
            case (R.id.b2):
                p=1;
                break;
            case (R.id.b3):
                p=2;
                break;
            case (R.id.b4):
                p=3;
                break;
            case (R.id.b5):
                p=4;
                break;
            case (R.id.b6):
                p=5;
                break;
            case (R.id.b7):
                p=6;
                break;
            case (R.id.b8):
                p=7;
                break;
        }

        if(zenbakik.get(p) == 1)
            z = "Bat";
        else if (zenbakik.get(p) == 2)
            z = "Bi";
        else if (zenbakik.get(p) == 3)
            z = "Hiru";
        else if (zenbakik.get(p) == 4)
            z = "Lau";
        else if (zenbakik.get(p) == 5)
            z = "Bost";
        else if (zenbakik.get(p) == 6)
            z = "Sei";
        else if (zenbakik.get(p) == 7)
            z = "Zazpi";
        else if (zenbakik.get(p) == 8)
            z = "Zortzi";
        else if (zenbakik.get(p) == 9)
            z = "Bederatzi";
        else if (zenbakik.get(p) == 10)
            z = "Hamar";
        else if (zenbakik.get(p) == 11)
            z = "Hamaika";
        else if (zenbakik.get(p) == 12)
            z = "Hamabi";
        else if (zenbakik.get(p) == 13)
            z = "Hamairu";
        else if (zenbakik.get(p) == 14)
            z = "Hamalau";
        else if (zenbakik.get(p) == 15)
            z = "Hamabost";
        else if (zenbakik.get(p) == 16)
            z = "Hamasei";
        else if (zenbakik.get(p) == 17)
            z = "Hamazazpi";
        else if (zenbakik.get(p) == 18)
            z = "Hemezortzi";
        else if (zenbakik.get(p) == 19)
            z = "Hemeretzi";
        else if (zenbakik.get(p) == 20)
            z = "Hogei";

        if(z.equals(zenbakikL.get(i))){
            findViewById(view.getId()).setEnabled(false);
            ondo++;
        }


    }



    public void zuzendu(View view){

        user = User.getInstance("","");

        new ProgressTask<String>(this){
            @Override
            protected String work() throws Exception{
                Date date = new Date();
                play = new Play(user.getName(),6,ondo,date.toString());
                return server.emaitzaIgo(play);
            }

            @Override
            protected void onFinish(String result){
                if(result.equals("Emaitza ondo gorde da")){
                    if(ondo==8){
                        Toast.makeText(getApplicationContext(),"Ondo!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Menu1Activity.class);
                        //intent.putExtra(Menu1Activity.MAILA_EXTRA,1);

                        //Shared preferences
                        SharedPreferences prefs = getSharedPreferences(user.getName(),MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("PREF_MAILA",3);
                        editor.commit();

                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Saiatu berriro!", Toast.LENGTH_SHORT).show();

                        Bingoa b = new Bingoa();
                        TextView a = (TextView)findViewById(R.id.zenbaki);
                        zenbakikL = b.shuffleString();
                        a.setText((CharSequence) zenbakikL.get(0));

                        zenbakik = b.shuffleInt();
                        Button b1 = (Button)findViewById(R.id.b1);
                        Button b2 = (Button)findViewById(R.id.b2);
                        Button b3 = (Button)findViewById(R.id.b3);
                        Button b4 = (Button)findViewById(R.id.b4);
                        Button b5 = (Button)findViewById(R.id.b5);
                        Button b6 = (Button)findViewById(R.id.b6);
                        Button b7 = (Button)findViewById(R.id.b7);
                        Button b8 = (Button)findViewById(R.id.b8);

                        b1.setText(zenbakik.get(0).toString());
                        b2.setText(zenbakik.get(1).toString());
                        b3.setText(zenbakik.get(2).toString());
                        b4.setText(zenbakik.get(3).toString());
                        b5.setText(zenbakik.get(4).toString());
                        b6.setText(zenbakik.get(5).toString());
                        b7.setText(zenbakik.get(6).toString());
                        b8.setText(zenbakik.get(7).toString());

                        ondo = 0;
                        i = 0;

                        findViewById(R.id.b1).setEnabled(true);
                        findViewById(R.id.b2).setEnabled(true);
                        findViewById(R.id.b3).setEnabled(true);
                        findViewById(R.id.b4).setEnabled(true);
                        findViewById(R.id.b5).setEnabled(true);
                        findViewById(R.id.b6).setEnabled(true);
                        findViewById(R.id.b7).setEnabled(true);
                        findViewById(R.id.b8).setEnabled(true);

                        findViewById(R.id.hurrengoa).setEnabled(true);

                    }


                }
                else if (result.equals("Emaitza ez da gorde")){
                    Toast.makeText(getApplicationContext(),"Ez da emaitza gorde", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(getApplicationContext(),"KX ez", Toast.LENGTH_SHORT).show();

            }

        }.execute();

        /*if(ondo == 8){
            Toast.makeText(getApplicationContext(), "Ondo!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Menu1Activity.class);
            intent.putExtra(Menu1Activity.MAILA_EXTRA,1);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Saiatu berriro!", Toast.LENGTH_SHORT).show();

            Bingoa b = new Bingoa();
            TextView a = (TextView)findViewById(R.id.zenbaki);
            zenbakikL = b.shuffleString();
            a.setText((CharSequence) zenbakikL.get(0));

            zenbakik = b.shuffleInt();
            Button b1 = (Button)findViewById(R.id.b1);
            Button b2 = (Button)findViewById(R.id.b2);
            Button b3 = (Button)findViewById(R.id.b3);
            Button b4 = (Button)findViewById(R.id.b4);
            Button b5 = (Button)findViewById(R.id.b5);
            Button b6 = (Button)findViewById(R.id.b6);
            Button b7 = (Button)findViewById(R.id.b7);
            Button b8 = (Button)findViewById(R.id.b8);

            b1.setText(zenbakik.get(0).toString());
            b2.setText(zenbakik.get(1).toString());
            b3.setText(zenbakik.get(2).toString());
            b4.setText(zenbakik.get(3).toString());
            b5.setText(zenbakik.get(4).toString());
            b6.setText(zenbakik.get(5).toString());
            b7.setText(zenbakik.get(6).toString());
            b8.setText(zenbakik.get(7).toString());

            ondo = 0;
            i = 0;

            findViewById(R.id.b1).setEnabled(true);
            findViewById(R.id.b2).setEnabled(true);
            findViewById(R.id.b3).setEnabled(true);
            findViewById(R.id.b4).setEnabled(true);
            findViewById(R.id.b5).setEnabled(true);
            findViewById(R.id.b6).setEnabled(true);
            findViewById(R.id.b7).setEnabled(true);
            findViewById(R.id.b8).setEnabled(true);

            findViewById(R.id.hurrengoa).setEnabled(true);

        }*/

    }
}
