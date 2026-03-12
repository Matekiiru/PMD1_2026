package com.example.imcapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.imcapp.R;
import com.example.imcapp.controller.Controle;

import java.util.List;

public class ResultadoActivity extends AppCompatActivity {

    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        textResultado = findViewById(R.id.textResultado);
        Intent intent = getIntent();
        String resultado = intent.getStringExtra("resultado");
        textResultado.setText(resultado);

    }

}