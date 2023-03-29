package com.example.moeda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class boletim extends AppCompatActivity {

    EditText txt_Nome, txt_Nota1, txt_Nota2, txt_Nota3;
    Button btn_Calcular;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boletim);

        AlertDialog.Builder alerta = new AlertDialog.Builder(boletim.this);
        AlertDialog.Builder alertaRecup = new AlertDialog.Builder(boletim.this);


        final View layout = getLayoutInflater().inflate(R.layout.activity_resultado, null);
        alertaRecup.setView(layout);

        txt_Nome = findViewById(R.id.txt_Nome);
        txt_Nota1 = findViewById(R.id.txt_Nota1);
        txt_Nota2 = findViewById(R.id.txt_Nota2);
        txt_Nota3 = findViewById(R.id.txt_Nota3);
        btn_Calcular = findViewById(R.id.btn_Calcular);

        btn_Calcular.setOnClickListener(v -> {

            DecimalFormat arredondar = new DecimalFormat("#.##");

            if (TextUtils.isEmpty(txt_Nome.getText().toString()) || TextUtils.isEmpty(txt_Nota1.getText().toString()) || TextUtils.isEmpty(txt_Nota2.getText().toString()) || TextUtils.isEmpty(txt_Nota3.getText().toString())) {
                alerta.setTitle("ATENÇÃO");
                alerta.setMessage("Um dos campos está vazio!");
                alerta.setPositiveButton("Sair", null);
                alerta.setCancelable(false);
                alerta.show();
            } else {
                double nota1 = Double.parseDouble(txt_Nota1.getText().toString());
                double nota2 = Double.parseDouble(txt_Nota2.getText().toString());
                double nota3 = Double.parseDouble(txt_Nota3.getText().toString());
                double resultado = (nota1 + nota2 + nota3 * 2) / 4;
                String vlrFinal = arredondar.format(resultado);

                if (resultado >= 9) {
                    alerta.setTitle("NOTA FINAL");
                    alerta.setMessage("Aluno: " + txt_Nome.getText().toString() + "\nMédia fina: " + vlrFinal + "\nConceito: A (APROVADO)");
                    alerta.setPositiveButton("Sair", null);
                    alerta.setCancelable(false);
                    alerta.show();
                } else if (resultado >= 7) {
                    alerta.setTitle("NOTA FINAL");
                    alerta.setMessage("Aluno: " + txt_Nome.getText().toString() + "\nMédia fina: " + vlrFinal + "\nConceito: B (APROVADO)");
                    alerta.setPositiveButton("Sair", null);
                    alerta.setCancelable(false);
                    alerta.show();
                } else if (resultado < 7) {
                    alertaRecup.setTitle("NOTA FINAL");
                    alertaRecup.setMessage("Aluno: " + txt_Nome.getText().toString() + "\nMédia fina: " + vlrFinal + "\nConceito: C (RECUPERAÇÃO)");
                    alertaRecup.setPositiveButton("Calcular", (dialog, which) -> {

                        EditText txt_Recup = layout.findViewById(R.id.txt_Recup);

                        if (TextUtils.isEmpty(txt_Recup.getText().toString())) {
                            Toast.makeText(boletim.this, "Favor inserir nota de recuperação!", Toast.LENGTH_SHORT).show();
                        } else {
                            double notaRecup = Double.parseDouble(txt_Recup.getText().toString());
                            double resultadoRecup = (resultado + notaRecup * 2) / 3;
                            String vlrFinalRecup = arredondar.format(resultadoRecup);

                            alerta.setTitle("RECUPERAÇÃO");
                            if (resultadoRecup >= 7) {
                                alerta.setMessage("Aluno: " + txt_Nome.getText().toString() + "\nNota: " + vlrFinalRecup + " APROVADO POR RECUPERAÇÃO");



                            } else {

                                alerta.setMessage("Aluno: " + txt_Nome.getText().toString() + "\nNota: " + vlrFinalRecup + " REPROVADO");
                            }
                            alerta.setPositiveButton("Sair", null);
                            alerta.setCancelable(false);
                            alerta.show();
                        }
                    });
                    alertaRecup.setCancelable(false);
                    alertaRecup.show();




                } else if (resultado <= 5) {
                    alerta.setTitle("NOTA FINAL");
                    alerta.setMessage("Aluno: " + txt_Nome.getText().toString() + "\nMédia fina: " + resultado + "\nConceito: D (REPROVADO)");
                    alerta.setPositiveButton("Sair", null);
                    alerta.setCancelable(false);
                    alerta.show();
                }
            }
        });
    }
}