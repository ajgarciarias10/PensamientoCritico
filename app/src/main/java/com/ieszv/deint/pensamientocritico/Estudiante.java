package com.ieszv.deint.pensamientocritico;

import java.io.Serializable;

public class Estudiante  {
  //Creamos lo que vamos a almacenar del estudiante
    private  String  nombre,primerapell,secapell, curso, letra,centroEducativo,id;
    //CREAMOS LOS CONSTRUCTORES

    //Constructor al completop
    public Estudiante(String nombre, String primerapell, String secapell, String curso, String letra, String centroEducativo, String id) {
        this.nombre = nombre;
        this.primerapell = primerapell;
        this.secapell = secapell;
        this.curso = curso;
        this.letra = letra;
        this.centroEducativo = centroEducativo;
        this.id = id;
    }
    //CREAMOS CONSTRUCTOR VACIO
    public Estudiante() {
        this("","","","","","","");
    }
}
