package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

public class Servicio {
   private int idservicio ;
   private Date fecha ;
   private String tipodepago ;

    public Servicio(int idservicio, Date fecha, String tipodepago) {
        this.idservicio = idservicio;
        this.fecha = fecha;
        this.tipodepago = tipodepago;
    }

    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("fecha",getFecha());
            jsonObject.put("tipodepago", getTipodepago());

            jsonText = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonText;
    }

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipodepago() {
        return tipodepago;
    }

    public void setTipodepago(String tipodepago) {
        this.tipodepago = tipodepago;
    }
}
