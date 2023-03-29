package com.example.moeda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class posto extends AppCompatActivity {

    EditText txt_ValorEtanol, txt_ValorGasolina;
    Button btn_Calcular;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posto);

        txt_ValorEtanol = findViewById(R.id.txt_ValorEtanol);
        txt_ValorGasolina = findViewById(R.id.txt_ValorGasolina);
        btn_Calcular = findViewById(R.id.btn_Calcular);



        btn_Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double resultado = Double.parseDouble(txt_ValorEtanol.getText().toString())/Double.parseDouble(txt_ValorGasolina.getText().toString());


                if (resultado > 0.7) {
                    btn_Calcular.setBackgroundResource(R.drawable.up);
                } else {
                    btn_Calcular.setBackgroundResource(R.drawable.down);
                }
            }
        });
    }
}