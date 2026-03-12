package com.example.imcapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.imcapp.R;
import com.example.imcapp.controller.Controle;
import com.example.imcapp.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextIdade, editTextAltura, editTextPeso;
    private TextView textViewResultado;
    private Button buttonCalcular;

    private Controle controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        editTextAltura = findViewById(R.id.editTextAltura);
        editTextPeso = findViewById(R.id.editTextPeso);

        textViewResultado = findViewById(R.id.textViewResultado);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        controle = new Controle();

        buttonCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String nome = editTextNome.getText().toString();
                String idade = editTextIdade.getText().toString();
                String altura = editTextAltura.getText().toString();
                String peso = editTextPeso.getText().toString();
                controle.adicionarPessoa(nome,idade,altura,peso);

                if(controle.quantidadePessoas() == 5){

                    Intent intent = new Intent(MainActivity.this,ResultadoActivity.class);

                    intent.putExtra("resultado",controle.getResultado());
                    startActivity(intent);

                }


            }
        });
    }
}