package com.example.bajip.myapplication;

import android.app.Dialog;
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

public class MainActivity extends AppCompatActivity {


    ImageButton pindah;
    EditText username , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pindah = (ImageButton) findViewById(R.id.login);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("") && passwordKey.equals("")) {

                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
                            Toast.LENGTH_SHORT).show();
                    pindah.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, FakultasActivity.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    //jika login gagal

                    final Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.activity_register);
                    dialog.setTitle("INFORMATION");

                    /**
                     * Mengeset komponen dari custom dialog
                     */
                    TextView text = (TextView) dialog.findViewById(R.id.tv_desc);
                    text.setText("Id User dan Password salah apakah anda ingin registrasi..??");
                    Button dialogButton = (Button) dialog.findViewById(R.id.bt_ok);
                    /**
                     * Jika tombol diklik, tutup dialog dan berpindah layout
                     */
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent intent = new Intent(MainActivity.this, registerActivity.class);
                            startActivity(intent);

                        }
                    });

                    dialog.show();
                    //AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    //builder.setMessage("Username atau Password Anda salah!")
                    // .setNegativeButton("Retry", null).create().show();
                }


            }
        });
    }

}