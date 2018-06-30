package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfeZona {
   private int id       ;
  private int id_profe  ;
  private int id_zona   ;

    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id_profe",getId_profe());
            jsonObject.put("id_zona", getId_zona());

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

    public int getId_profe() {
        return id_profe;
    }

    public void setId_profe(int id_profe) {
        this.id_profe = id_profe;
    }

    public int getId_zona() {
        return id_zona;
    }

    public void setId_zona(int id_zona) {
        this.id_zona = id_zona;
    }
}
