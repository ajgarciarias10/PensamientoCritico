package com.ieszv.deint.pensamientocritico;

import android.os.Build;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MetodosAUtilizar {

    private static final String TAG = "VIVALAPEPA";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public  static String sacarElId(String nombre, String primerapell, String segundoapell, String curso, String letra, String fechaActual){

        String idFinal,nombreinicial,primerapellinicial,segundoapellinicial;

        //region Sacamos la posicion 0 EN EL SUBSTRING DE CADA CADENA QUE VAMOS A UTILIZAR
            nombreinicial = nombre.substring(0);
            primerapellinicial =primerapell.substring(0);
            segundoapellinicial = segundoapell.substring(0);
        //endregion
         //region Sacamos la fecha actual
        //CLASE DATETIME FORMATER PARA UTILIZAR LA FECHA ACTUAL
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
             fechaActual =  dtf.format(LocalDateTime.now());
        //endregion

        //region Sacamos la suma de todas la cadenas para asi tener el id
            idFinal = nombreinicial + primerapellinicial + segundoapellinicial + curso + letra +fechaActual;
        //endregion


        return idFinal;
    }
        public  static   boolean checkingEMPTYFIELDs (EditText editalo) {
            if (editalo.getText().toString().isEmpty() || editalo.getText().toString() == null) {
                editalo.setError("Error debes rellenar el campo de texto");
                return false;
            } else {
                return true;
            }
        }
    public static boolean writeFile(File file, String resultado) {
        File f = new File(file, "resultados.txt");
        FileWriter fw = null;
        boolean ok = true;
        try {
            fw = new FileWriter(f, true);
            fw.write(resultado);
            fw.write("\n");
            fw.flush();
            fw.close();
        } catch (IOException e) {
            ok = false;
            Log.v(TAG, e.toString());
        }
        return ok;
    }
    public static  String readFile(File file, String filename){
        File f = new File(file, filename);
        String texto = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea;
            while((linea = br.readLine()) != null) {
                texto +=  linea + "\n";
            }
            br.close();
        } catch (Exception e){
            texto = null;
        }
        return texto;
    }



}
