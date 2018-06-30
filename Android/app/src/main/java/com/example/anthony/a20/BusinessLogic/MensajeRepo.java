package com.example.anthony.a20.BusinessLogic;

import android.util.JsonReader;

import com.example.anthony.a20.Entities.Horario;
import com.example.anthony.a20.Entities.Mensaje;
import com.example.anthony.a20.Entities.Profesor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;

public class MensajeRepo implements  IMensajeRepo{

    @Override
    public Mensaje getMensaje(int id) {
        ArrayList<Mensaje> mensajes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/mensajes?id="+id);

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
                    int idmensaje =0;
                    String hora ="";
                    Date fecha=null;
                    String contenido ="";
                    int id_padre =0;
                    int id_profe =0;
                    String remitente ="";

                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idmensaje":
                                idmensaje=jsonReader.nextInt();
                                break;
                            case "hora":
                                hora=jsonReader.nextString();
                                break;
                            case "fecha":
                                fecha=Date.valueOf(jsonReader.nextString());
                                break;
                            case "contenido":
                                contenido=jsonReader.nextString();
                                break;
                            case "id_padre":
                                id_padre=jsonReader.nextInt();
                                break;
                            case "id_profe":
                                id_profe=jsonReader.nextInt();
                                break;
                            case "remitente":
                                remitente=jsonReader.nextString();
                                break;

                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Mensaje obj=new Mensaje( idmensaje,  hora,  fecha,  contenido,  id_padre,  id_profe,  remitente);
                    mensajes.add(obj);
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

        return mensajes.get(0) ;
    }

    @Override
    public ArrayList<Mensaje> getMensajes(int idpadre, int idprofe) {
        ArrayList<Mensaje> mensajes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/mensajes?idpadre="+idpadre+"&idprofe="+idprofe);

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
                    int idmensaje =0;
                    String hora ="";
                    Date fecha=null;
                    String contenido ="";
                    int id_padre =0;
                    int id_profe =0;
                    String remitente ="";

                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idmensaje":
                                idmensaje=jsonReader.nextInt();
                                break;
                            case "hora":
                                hora=jsonReader.nextString();
                                break;
                            case "fecha":
                                fecha=Date.valueOf(jsonReader.nextString());
                                break;
                            case "contenido":
                                contenido=jsonReader.nextString();
                                break;
                            case "id_padre":
                                id_padre=jsonReader.nextInt();
                                break;
                            case "id_profe":
                                id_profe=jsonReader.nextInt();
                                break;
                            case "remitente":
                                remitente=jsonReader.nextString();
                                break;

                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Mensaje obj=new Mensaje( idmensaje,  hora,  fecha,  contenido,  id_padre,  id_profe,  remitente);
                    mensajes.add(obj);
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

        return mensajes;
    }

    @Override
    public boolean createMensaje(Mensaje obj) {
        boolean result=false;
        try{
            URL apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/mensajes");

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
