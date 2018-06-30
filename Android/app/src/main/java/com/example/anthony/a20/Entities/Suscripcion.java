package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

public class Suscripcion {
    private int idsuscripcion ;
   private Date fechainicio ;
   private Date fechafin ;
    private int id_profesor ;

    public Suscripcion(int idsuscripcion, Date fechainicio, Date fechafin, int id_profesor) {
        this.idsuscripcion = idsuscripcion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.id_profesor = id_profesor;
    }

    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("fechainicio",getFechainicio());
            jsonObject.put("fechafin", getFechafin());
            jsonObject.put("id_profesor", getId_profesor());

            jsonText = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonText;
    }

    public int getIdsuscripcion() {
        return idsuscripcion;
    }

    public void setIdsuscripcion(int idsuscripcion) {
        this.idsuscripcion = idsuscripcion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }
}
