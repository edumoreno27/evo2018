package com.example.anthony.a20.Entities;

public class Cursogrado {
   private int idcursogrado     ;
   private String nombre        ;
   private String contenido         ;
   private String grado         ;

    public Cursogrado(int idcursogrado, String nombre, String contenido, String grado) {
        this.idcursogrado = idcursogrado;
        this.nombre = nombre;
        this.contenido = contenido;
        this.grado = grado;
    }
    public Cursogrado(){}
    public int getIdcursogrado() {
        return idcursogrado;
    }

    public void setIdcursogrado(int idcursogrado) {
        this.idcursogrado = idcursogrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}
