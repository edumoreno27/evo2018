package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

public class Mensaje {
   private int idmensaje ;
   private String hora ;
    private Date fecha;
   private String contenido ;
   private int id_padre ;
   private int id_profe ;
   private String remitente ;

    public Mensaje(int idmensaje, String hora, Date fecha, String contenido, int id_padre, int id_profe, String remitente) {
        this.idmensaje = idmensaje;
        this.hora = hora;
        this.fecha = fecha;
        this.contenido = contenido;
        this.id_padre = id_padre;
        this.id_profe = id_profe;
        this.remitente = remitente;
    }

    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("hora",getHora());
            jsonObject.put("fecha", getFecha());
            jsonObject.put("contenido", getContenido());
            jsonObject.put("id_padre", getId_padre());
            jsonObject.put("id_profe", getId_profe());
            jsonObject.put("remitente", getRemitente());


            jsonText = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonText;
    }
    public int getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(int idmensaje) {
        this.idmensaje = idmensaje;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public int getId_profe() {
        return id_profe;
    }

    public void setId_profe(int id_profe) {
        this.id_profe = id_profe;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

}
