package eus.ehu.adibidea.tta.apprendeus.Vista;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;

import eus.ehu.adibidea.tta.apprendeus.Modelo.ProgressTask;
import eus.ehu.adibidea.tta.apprendeus.Modelo.Server;
import eus.ehu.adibidea.tta.apprendeus.Modelo.User;
import eus.ehu.adibidea.tta.apprendeus.R;

public class LoginActivity extends AppCompatActivity {

    Uri pictureUri;
    public static final int PICTURE_REQUEST_CODE = 0;
    public static final int READ_REQUEST_CODE = 0;

    public final Server server = new Server("http://u017633.ehu.eus:28080/APPrendeus");
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) throws JSONException{

        user = User.getInstance(((EditText) findViewById(R.id.erab)).getText().toString(),((EditText) findViewById(R.id.password)).getText().toString());

        //user = new User(((EditText) findViewById(R.id.erab)).getText().toString(),((EditText) findViewById(R.id.password)).getText().toString());

        new ProgressTask<String>(this){
            @Override
            protected String work() throws Exception{
                return server.logIn(user);
            }

            @Override
            protected void onFinish(String result){
                if(result.equals("OK")){
                    Intent intent = new Intent(getApplicationContext(),Menu1Activity.class);
                    startActivity(intent);
                }
                else if (result.equals("Login ERROR")){
                    Toast.makeText(getApplicationContext(),"Logina ez da zuzena", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(getApplicationContext(),"KX ez", Toast.LENGTH_SHORT).show();

            }

        }.execute();
    }

    public void signIn(View view){

        user = User.getInstance(((EditText) findViewById(R.id.erab)).getText().toString(),((EditText) findViewById(R.id.password)).getText().toString());

        //user = new User(((EditText) findViewById(R.id.erab)).getText().toString(),((EditText) findViewById(R.id.password)).getText().toString());

        new ProgressTask<String>(this){
            @Override
            protected String work() throws Exception{
                return server.signIn(user);
            }

            @Override
            protected void onFinish(String result){
                if(result.equals("Erabiltzaile berria ondo gorde da")){
                    Toast.makeText(getApplicationContext(),"Ondo erregistratu zara", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Menu1Activity.class);
                    startActivity(intent);
                }
                else if (result.equals("Erabiltzaile hori badago dagoeneko")){
                    Toast.makeText(getApplicationContext(),"Erabiltzaile izen hori bagado dagoeneko", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(getApplicationContext(),"KX ez", Toast.LENGTH_SHORT).show();

            }

        }.execute();

    }

    public void argazkia(View view){
        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA))
            Toast.makeText(this,R.string.no_camera,Toast.LENGTH_SHORT).show();
        else{
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager())!=null){
                File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                try{
                    File file = File.createTempFile("tta",".jpg",dir);
                    pictureUri = Uri.fromFile(file);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,pictureUri);
                    startActivityForResult(intent,PICTURE_REQUEST_CODE);
                }
                catch(IOException e){

                }
            }
            else
                Toast.makeText(this,R.string.no_camera,Toast.LENGTH_SHORT).show();
        }
    }

    public void sendFile(Uri uri){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        startActivityForResult(intent,READ_REQUEST_CODE);


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode != Activity.RESULT_OK)
            return;
        switch (requestCode){
            case PICTURE_REQUEST_CODE:
                sendFile(pictureUri);
                break;
        }
    }
}
