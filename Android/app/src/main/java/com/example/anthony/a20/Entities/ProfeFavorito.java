package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfeFavorito {
     private int id ;
     private int id_profesor ;
     private int id_padre;
public ProfeFavorito(){

}
    public ProfeFavorito(int id, int id_profesor, int id_padre) {
        this.id = id;
        this.id_profesor = id_profesor;
        this.id_padre = id_padre;
    }

    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id_profesor",getId_profesor());
            jsonObject.put("id_padre", getId_padre());

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

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }
}
