package com.example.anthony.a20.BusinessLogic;

import android.util.JsonReader;

import com.example.anthony.a20.Entities.Servicio;
import com.example.anthony.a20.Entities.Zona;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;

public class ServicioRepo implements IServicioRepo {
    @Override
    public boolean createServicio(Servicio obj) {
        boolean result=false;
        try{
            URL apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/servicios");

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

    @Override
    public Servicio getServicio(int id) {
        ArrayList<Servicio> zonas=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/servicios?id="+id);

            //Crear conexión
            HttpURLConnection myConnection =
                    (HttpURLConnection) apiUrl.openConnection();

            //Procesar respuesta
            if (myConnection.getResponseCode()== 200){
                //Éxito
                //Further procesamiento aqui

                //Leyendo la respuesta
                InputStream responseBody= myConnection.getInputStream();

                //Usando lectura para respuesta
                InputStreamReader responseBodyReader=
                        new InputStreamReader(responseBody,"UTF-8");

                //Leyenso jason
                JsonReader jsonReader=new JsonReader(responseBodyReader);

                //Comenzar lectura del arreglo
                jsonReader.beginArray();

                //Leyendo elementos
                while (jsonReader.hasNext()){
                    //Leer cada objeto
                    jsonReader.beginObject();
                    int idservicio=0;
                    Date fecha=null ;
                    String tipodepago="";

                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idservicio":
                                idservicio=jsonReader.nextInt();
                                break;
                            case "fecha":
                                fecha=Date.valueOf(jsonReader.nextString());
                                break;
                            case "tipodepago":
                                tipodepago=jsonReader.nextString();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Servicio obj=new Servicio( idservicio,fecha,tipodepago);
                    zonas.add(obj);
                    jsonReader.endObject();
                }
                jsonReader.endArray();
                jsonReader.close();
                myConnection.disconnect();

            } else   {

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return zonas.get(0);
    }
}
