package com.example.anthony.a20.Entities;

public class Zona {
    private int idzona;
    private String zona1 ;
    public Zona(){}
    public Zona(int idzona, String zona1) {
        this.idzona = idzona;
        this.zona1 = zona1;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    public String getZona1() {
        return zona1;
    }

    public void setZona1(String zona1) {
        this.zona1 = zona1;
    }
}
