package com.ieszv.deint.pensamientocritico;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class notcia3  extends AppCompatActivity {
    ImageView fotiton1;
    Button btVerdadero, btFalso,btSiguiente;
    CheckBox ck1,ck2,ck3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noticia3);
        initialize();
    }
    BufferedReader fin; // Leemos el fichero.

    {
        try {
            fin = new BufferedReader(new InputStreamReader(openFileInput("imagenes.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String texto; //Cerramos el fichero fin.close();

    {
        try {
            texto = fin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Bitmap getBitmapFromURL(String src) {
        try { Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); connection.setDoInput(true); connection.connect();
            InputStream input = connection.getInputStream(); Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned"); return myBitmap; } catch (IOException e) { e.printStackTrace();
            Log.e("Exception",e.getMessage()); return null; } }

    public static  String[] extraerLinea1 (String textoarchivo){
        String[] linea;
        linea =  textoarchivo.substring(2).split(";");
        return  linea;

    }
    public String extraerSiEsVerdaderaOFalsa(){
        String[] linea = new String[2];
        linea= extraerLinea1(texto);
        String vof ;
        vof = linea.toString();
        return vof;
    }
    public String verSiEsVerdaderoOFalso(String booleano1, String booleanoverdadero){
        String texto;

        if(booleano1.equals(booleanoverdadero)){
            texto = "Correcta";
        }
        else{
            texto="Incorrecta";
        }
        return texto;
    }
    public String extraerTextoImagen(){
        String[] linea = new String[1];
        linea= extraerLinea1(texto);
        String url ;
        url = linea.toString();
        return url;
    }
    public String botonsitoCheck(){
        String verdadero;
        String resultado = "";
        if(btVerdadero.isPressed()){
            verdadero = "V";

            resultado = verSiEsVerdaderoOFalso(verdadero,extraerSiEsVerdaderaOFalsa());
        }
        else if(btFalso.isPressed()){
            verdadero = "F";

            resultado = verSiEsVerdaderoOFalso(verdadero,extraerSiEsVerdaderaOFalsa());

        }
        return  resultado;
    }
    private void initialize() {

        fotiton1 = findViewById(R.id.img_noticia);
        btVerdadero = findViewById(R.id.bt_verdadero);
        btFalso = findViewById(R.id.bt_falso);
        btSiguiente = findViewById(R.id.btSiguiente);
        fotiton1.setImageBitmap(getBitmapFromURL(extraerTextoImagen()));
        ck1 = findViewById(R.id.checkBox);
        ck2 = findViewById(R.id.checkBox2);
        ck3 = findViewById(R.id.checkBox3);
        if(btVerdadero.isPressed()){
            ck1.setText("Difundida en otros medios");
            ck2.setText("Autor contrastado de prestigio");
            ck3.setText("Es actual o con mucha cobertura en medios");
        }
        else if(btFalso.isPressed()){
            ck1.setText("No Difundida en otros medios");
            ck2.setText("Autor desconocido ");
            ck3.setText("No actual , evento pasado o irrelevante");
        }

        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(notcia3.this, noticia4.class);
                startActivity(intent);
                MetodosAUtilizar.writeFile(getFilesDir(),botonsitoCheck());



            }
        });

    }




}
