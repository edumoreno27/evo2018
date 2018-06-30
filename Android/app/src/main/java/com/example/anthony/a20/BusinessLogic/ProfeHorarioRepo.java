package com.example.anthony.a20.BusinessLogic;

import android.util.JsonReader;

import com.example.anthony.a20.Entities.ProfeHorario;
import com.example.anthony.a20.Entities.Profesor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProfeHorarioRepo implements  IProfeHorarioRepo{
    @Override
    public boolean createProfeHorario(ProfeHorario obj) {

        boolean result=false;
        try{
            URL apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesor_horario");

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
    public ArrayList<ProfeHorario> get(int id1,int id2) {
        ArrayList<ProfeHorario> profes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesor_horario");

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
                    int id     =0     ;
                    int id_profesor     =0     ;
                    int id_horario     =0     ;
                    String estado        =""   ;
                    Date fecha=null;
                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "id":
                                id=jsonReader.nextInt();
                                break;
                            case "id_profesor":
                                id_profesor=jsonReader.nextInt();
                                break;
                            case "id_horario":
                                id_horario=jsonReader.nextInt();
                                break;
                            case "estado":
                                estado=jsonReader.nextString();
                                break;
                            case "fecha":
                                SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
                                String prueba2=jsonReader.nextString();
                                Date date2 =  sd.parse(prueba2);
                                fecha=date2;
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    ProfeHorario obj=null;
                    if(id_profesor == id1 && id_horario==id2) {
                        obj = new ProfeHorario(id, id_profesor, id_horario, estado, fecha);
                        profes.add(obj);
                    }

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
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return profes;
    }
}
