package com.example.moeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class moeda extends AppCompatActivity {

    EditText input;
    Button btn_calcular;
    TextView txt_show;
    RadioGroup rdGrupo;
    double vlrReal;
    String vlrFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moeda);

//Atribuíndo os valores na activity aos atributos da classe
        input = findViewById(R.id.input_txt);
        btn_calcular = findViewById(R.id.btn_calcular);
        txt_show = findViewById(R.id.txt_show);
        rdGrupo = findViewById(R.id.rdGrupo);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat arredondar = new DecimalFormat("#.##");

                if(TextUtils.isEmpty(input.getText().toString())){
                    Toast.makeText(moeda.this, "Favor insira um valor para conversão!", Toast.LENGTH_SHORT).show();
                }else {
                    int vlrSelecionado = rdGrupo.getCheckedRadioButtonId();
                    switch (vlrSelecionado) {
                        case R.id.rdDolar:
                            vlrReal = Double.parseDouble(input.getText().toString());
                            vlrFinal = "$ " + arredondar.format(vlrReal * 5.20);
                            txt_show.setText(String.valueOf(vlrFinal));
                            break;
                        case R.id.rdEuro:
                            vlrReal = Double.parseDouble(input.getText().toString());
                            vlrFinal = "€ " + arredondar.format(vlrReal * 5.65);
                            txt_show.setText(String.valueOf(vlrFinal));
                            break;
                        case R.id.rdLibra:
                            vlrReal = Double.parseDouble(input.getText().toString());
                            vlrFinal = "£ " + arredondar.format(vlrReal * 6.43);
                            txt_show.setText(String.valueOf(vlrFinal));
                            break;
                    }
                }
            }
        });


    }
}