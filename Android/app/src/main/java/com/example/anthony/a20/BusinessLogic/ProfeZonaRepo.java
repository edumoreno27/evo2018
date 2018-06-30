package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.ProfeZona;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ProfeZonaRepo implements IProfeZonaRepo {
    @Override
    public boolean createProfeZona(ProfeZona obj) {
        boolean result=false;
        try{
            URL apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesor_zona");

            //crear conexion
            HttpURLConnection myConnection=(HttpURLConnection)apiUrl.openConnection();

            myConnection.setRequestMethod("POST");
            myConnection.setDoOutput(true);

            //Set data
            myConnection.setRequestProperty("Content-Type", "application/json");
            myConnection.setRequestProperty("Accept", "application/json");
            String itemJson=obj.toJson();
            myConnection.getOutputStream().write(itemJson.getBytes());

            //Procesando respuesta
            if(myConnection.getResponseCode()==200)
            {
                //successo
                //Procesando
                result=true;
            }else{
                //fallando
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
