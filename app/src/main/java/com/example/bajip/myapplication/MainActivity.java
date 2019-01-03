package com.example.bajip.myapplication;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String JSON_STRING;
    ImageButton pindah;
    EditText txt_username , txt_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setSupportActionBar(toolbar);
        txt_username = findViewById(R.id.username);
        txt_password = findViewById(R.id.password);
        //daftar = findViewById(R.id.button_sign_up_activity_main);
        //Toast.makeText(Login.this,"ID Sesion : "+MainActivity.id_user_s,Toast.LENGTH_SHORT).show();
        //daftar.setOnClickListener();
        pindah = (ImageButton) findViewById(R.id.login);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJSON();
            }
        });

    }
    @Override
    public void onBackPressed() {
        finish();
    }

    public void Buatakun(View view) {
        Intent keregister = new Intent(MainActivity.this, registerActivity.class);
        startActivity(keregister);
        finish();
    }

    private void getJSON(){

        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();

            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasiuser.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    private void showEmployee(){

        JSONObject jsonObject = null;
//        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasiuser.TAG_JSON_ARRAY);
            //Toast.makeText(Login.this,"Get Jsoaaan : "+result,Toast.LENGTH_LONG).show();
            for(int i = 0; i<result.length(); i++){
                JSONObject jo = result.getJSONObject(i);
                String ID = jo.getString(konfigurasiuser.TAG_id_nrp);
                String PASSWORD = jo.getString(konfigurasiuser.TAG_password);

                //Toast.makeText(Login.this,"Get Json : "+nama,Toast.LENGTH_LONG).show();
                String admin="admin";

                if(ID.equals(txt_username.getText().toString()) && PASSWORD.equals(txt_password.getText().toString()) ) {
                    //Toast.makeText(Login.this, "Email : " + txt_username.getText() + " Password : " + txt_password.getText() + " Anda berhasil Login", Toast.LENGTH_SHORT).show();
                    //sesi.setId_user(id);
                    Toast.makeText(MainActivity.this,"Anda Berhasil Login.",Toast.LENGTH_LONG).show();

                    Intent kemain = new Intent(MainActivity.this, FakultasActivity.class);
                    startActivity(kemain);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this,"aasdasd", Toast.LENGTH_SHORT).show();
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    }
