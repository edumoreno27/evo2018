package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

public class MetodoPago {
    private int id;
    private String nombre ;
    private String numerotarjeta;
    private Date fecha ;
    private String cvv ;

    public MetodoPago(int id, String nombre, String numerotarjeta, Date fecha, String cvv) {
        this.id = id;
        this.nombre = nombre;
        this.numerotarjeta = numerotarjeta;
        this.fecha = fecha;
        this.cvv = cvv;
    }

    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nombre",getNombre());
            jsonObject.put("numerotarjeta", getNumerotarjeta());
            jsonObject.put("fecha", getFecha());
            jsonObject.put("cvv", getCvv());
       
            jsonText = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumerotarjeta() {
        return numerotarjeta;
    }

    public void setNumerotarjeta(String numerotarjeta) {
        this.numerotarjeta = numerotarjeta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
