package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.Date;

public class ProfeHorario {
   private int id;
   private int id_profesor ;
   private int id_horario ;
   private String estado ;
   private Date fecha ;

    public ProfeHorario(int id, int id_profesor, int id_horario, String estado, Date fecha) {
        this.id = id;
        this.id_profesor = id_profesor;
        this.id_horario = id_horario;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id_profesor",getId_profesor());
            jsonObject.put("id_horario", getId_horario());
            jsonObject.put("estado", getEstado());
            jsonObject.put("fecha", getFecha());
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

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
