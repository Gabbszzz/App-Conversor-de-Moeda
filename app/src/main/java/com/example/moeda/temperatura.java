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

public class temperatura extends AppCompatActivity {

    EditText input_txt;

    Button btnConverser;

    TextView txtShow;

    RadioGroup group;

    Double vlrCel;

    String vlrConvertido;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        input_txt=findViewById(R.id.editTextNumber);
        btnConverser=findViewById(R.id.button2);
        txtShow=findViewById(R.id.editTextNumber2);
        group=findViewById(R.id.radioGroup);

        btnConverser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat arredondar = new DecimalFormat("##.##");

                if(TextUtils.isEmpty(input_txt.getText().toString())){
                    Toast.makeText(temperatura.this, "Insira um valor a ser convertido!!!", Toast.LENGTH_SHORT).show();
                }else{
                    int idSelect=group.getCheckedRadioButtonId();
                    switch (idSelect){
                        case R.id.radioButton2:
                            vlrCel=Double.parseDouble(input_txt.getText().toString());
                            vlrConvertido=arredondar.format(vlrCel*1.8+32);
                            txtShow.setText(String.valueOf(vlrConvertido)+" ºF");
                            break;
                        case R.id.radioButton3:
                            vlrCel=Double.parseDouble(input_txt.getText().toString());
                            vlrConvertido= arredondar.format(vlrCel+273.15);
                            txtShow.setText(String.valueOf(vlrConvertido)+" ºK");
                            break;
                        default:
                            Toast.makeText(temperatura.this, "Insira uma das opções!!!", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
        });
    }
}
