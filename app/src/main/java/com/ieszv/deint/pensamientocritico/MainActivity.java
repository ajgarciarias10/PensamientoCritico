package com.ieszv.deint.pensamientocritico;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt_empecemos;
    EditText etNombre, etprimerapell, etsegundoaepll;
    MetodosAUtilizar metodosAUtilizar = new MetodosAUtilizar();
    public static ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialize();
    }

    private void initialize() {

        //region CARGAMOS LOS SPINNER
        Spinner spinner = (Spinner) findViewById(R.id.sp_curso);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_curso, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //COGEMOS DATOS SPINNER


        Spinner spinner2 = (Spinner) findViewById(R.id.sp_letra);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner_Letra, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);


        Spinner spinner3 = (Spinner) findViewById(R.id.sp_centro);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.spinner_Centro, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        //endregion
        etNombre = findViewById(R.id.etNombre);
        etprimerapell = findViewById(R.id.etPrimerApellido);
        etsegundoaepll = findViewById(R.id.etPrimerApellido2);
        bt_empecemos = findViewById(R.id.bt_START);
        bt_empecemos.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                //region Inicializamos los objetos a utilizar y guardamos texto
                    String nombre = etNombre.getText().toString();
                    String primerapellido = etprimerapell.getText().toString();
                    String segundoapellido = etsegundoaepll.getText().toString();
                    String spinnerCurso = spinner.getSelectedItem().toString();
                    String spinnerLetra = spinner2.getSelectedItem().toString();
                    String spinnerCentro = spinner3.getSelectedItem().toString();
                    String id;
                    id = MetodosAUtilizar.sacarElId(nombre, primerapellido, segundoapellido, spinnerCurso, spinnerLetra, spinnerCentro);
                    Estudiante estudiante = new Estudiante(nombre, primerapellido, segundoapellido, spinnerCurso, spinnerLetra, spinnerCentro, id);
                    listaEstudiantes.add(estudiante);
                    Intent intent = new Intent(MainActivity.this, noticia1.class);
                    startActivity(intent);


            }
        });
    }

}