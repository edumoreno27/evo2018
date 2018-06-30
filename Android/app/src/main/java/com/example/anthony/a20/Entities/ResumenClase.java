package com.example.anthony.a20.Entities;


import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

public class ResumenClase {
    private int idresumen;
    private String descripcion;
    private Date fecha;
    private int  id_tutoria;

    public ResumenClase(int idresumen, String descripcion, Date fecha, int id_tutoria) {
        this.idresumen = idresumen;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.id_tutoria = id_tutoria;
    }

    public String toJson(){

        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("descripcion",getDescripcion());
            jsonObject.put("fecha", getFecha());
            jsonObject.put("id_tutoria", getId_tutoria());

            jsonText = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonText;
    }

    public int getIdresumen() {
        return idresumen;
    }

    public void setIdresumen(int idresumen) {
        this.idresumen = idresumen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_tutoria() {
        return id_tutoria;
    }

    public void setId_tutoria(int id_tutoria) {
        this.id_tutoria = id_tutoria;
    }
}
