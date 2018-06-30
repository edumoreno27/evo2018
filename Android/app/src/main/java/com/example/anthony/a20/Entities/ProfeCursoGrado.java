package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfeCursoGrado {
    private int id;
    private int id_profesor;
    private int id_cursogrado;

    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id_profesor",getId_profesor());
            jsonObject.put("id_cursogrado", getId_cursogrado());

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

    public int getId_cursogrado() {
        return id_cursogrado;
    }

    public void setId_cursogrado(int id_cursogrado) {
        this.id_cursogrado = id_cursogrado;
    }
}
