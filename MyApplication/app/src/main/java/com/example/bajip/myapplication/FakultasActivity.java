package com.example.bajip.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FakultasActivity extends AppCompatActivity {

    ImageButton pindah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fakultas);


        pindah = (ImageButton) findViewById(R.id.button_fmipa);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FakultasActivity.this,f_mipa.class);
                startActivity(intent);
            }
        });

        pindah = (ImageButton) findViewById(R.id.button_faperta);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FakultasActivity.this,f_faperta.class);
                startActivity(intent);
            }
        });

        pindah = (ImageButton) findViewById(R.id.button_fpik);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FakultasActivity.this,f_fpik.class);
                startActivity(intent);
            }
        });

        pindah = (ImageButton) findViewById(R.id.button_fapet);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FakultasActivity.this,f_fapet.class);
                startActivity(intent);
            }
        });


        pindah = (ImageButton) findViewById(R.id.button_fkehutanan);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FakultasActivity.this,f_fhut.class);
                startActivity(intent);
            }
        });

        pindah = (ImageButton) findViewById(R.id.button_fem);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FakultasActivity.this,f_fem.class);
                startActivity(intent);
            }
        });

        pindah = (ImageButton) findViewById(R.id.button_fema);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FakultasActivity.this,f_fema.class);
                startActivity(intent);
            }
        });

        pindah = (ImageButton) findViewById(R.id.button_fkh);
        pindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FakultasActivity.this,f_fkh.class);
                startActivity(intent);
            }
        });

    }
}
