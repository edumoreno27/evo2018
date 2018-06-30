package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

public class Hijo {
  private int idhijo ;
 private int id_tutoria ;
  private int id_padre ;
    private String nombre ;
    private String descripcion;

    public int getIdhijo() {
        return idhijo;
    }

    public void setIdhijo(int idhijo) {
        this.idhijo = idhijo;
    }

    public int getId_tutoria() {
        return id_tutoria;
    }

    public void setId_tutoria(int id_tutoria) {
        this.id_tutoria = id_tutoria;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id_tutoria",getId_tutoria());
            jsonObject.put("id_padre", getId_padre());
            jsonObject.put("nombre", getNombre());
            jsonObject.put("descripcion", getDescripcion());

            jsonText = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonText;
    }
}
