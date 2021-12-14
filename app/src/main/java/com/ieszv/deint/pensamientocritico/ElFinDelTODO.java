package com.ieszv.deint.pensamientocritico;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ElFinDelTODO extends AppCompatActivity {
    TextView tv_resultado;
    Button bt_FIN;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fin);
        initalize();
    }
    String texto = MetodosAUtilizar.readFile(getFilesDir(),"resultados.txt");

    private void initalize() {
        tv_resultado = findViewById(R.id.textView);
        tv_resultado.setText(texto);
        bt_FIN = findViewById(R.id.BT_FIN);
        bt_FIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
