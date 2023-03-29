package com.example.moeda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btn_moeda, btn_temp, btn_imc, btn_posto, btn_boletim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_moeda = findViewById(R.id.btn_moeda);
        btn_temp = findViewById(R.id.btn_temp);
        btn_imc = findViewById(R.id.btn_imc);
        btn_posto = findViewById(R.id.btn_posto);
        btn_boletim = findViewById(R.id.btn_boletim);

        btn_moeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page = new Intent(MainActivity.this,moeda.class);
                startActivity(page);
            }
        });

        btn_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page2 = new Intent(MainActivity.this,temperatura.class);
                startActivity(page2);
            }
        });

        btn_imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page3 = new Intent(MainActivity.this,imc.class);
                startActivity(page3);
            }
        });

        btn_posto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page = new Intent(MainActivity.this,posto.class);
                startActivity(page);
            }
        });

        btn_boletim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page = new Intent(MainActivity.this,boletim.class);
                startActivity(page);
            }
        });
    }
}