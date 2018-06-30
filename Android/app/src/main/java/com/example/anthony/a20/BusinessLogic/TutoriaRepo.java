package com.example.anthony.a20.BusinessLogic;

import android.util.JsonReader;

import com.example.anthony.a20.Entities.Suscripcion;
import com.example.anthony.a20.Entities.Tutoria;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TutoriaRepo implements ITutoriaRepo {
    @Override
    public boolean createTutoria(Tutoria obj) {
        boolean result=false;
        try{
            URL apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/tutorias");

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
    public ArrayList<Tutoria> getTutoriasDelPadre(int idpadre) {
        ArrayList<Tutoria> tutorias=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/tutorias?idpadre="+idpadre);

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
                    int idtutoria=0;
                    Date hora =null;
                    Date fecha=null ;
                    Double  precio=0.0;
                    String comentario="";
                    int calificacion=0 ;
                    int id_padre=0;
                    String estado="";
                    String curso="";
                    int id_horario=0;
                    int id_servicio=0;
                    int numerohoras=0;

                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idtutoria":
                                idtutoria=jsonReader.nextInt();
                                break;
                            case "hora":
                                SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
                                String prueba=jsonReader.nextString();
                                Date date =  sf.parse(prueba);
                                hora=date;
                                break;
                            case "fecha":
                                SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
                                String prueba2=jsonReader.nextString();
                                Date date2 =  sd.parse(prueba2);
                                fecha=date2;
                                break;
                            case "precio":
                                precio=jsonReader.nextDouble();
                                break;
                            case "comentario":
                                comentario=jsonReader.nextString();
                                break;
                            case "calificacion":
                                calificacion=jsonReader.nextInt();
                                break;
                            case "id_padre":
                                id_padre=jsonReader.nextInt();
                                break;
                            case "estado":
                                estado=jsonReader.nextString();
                                break;
                            case "curso":
                                curso=jsonReader.nextString();
                                break;
                            case "id_horario":
                                id_horario=jsonReader.nextInt();
                                break;
                            case "id_servicio":
                                id_servicio=jsonReader.nextInt();
                                break;
                            case "numerohoras":
                                numerohoras=jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Tutoria obj=new Tutoria( idtutoria,  hora,  fecha,  precio,  comentario,  calificacion,  id_padre,  estado,  curso,  id_horario, id_servicio, numerohoras);
                    tutorias.add(obj);
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

        return tutorias;
    }

    @Override
    public ArrayList<Tutoria> getTutoriasDelProfe(int idprofe) {
        ArrayList<Tutoria> tutorias=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/tutorias?idprofe="+idprofe);

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
                    int idtutoria=0;
                    Date hora =null;
                    Date fecha=null ;
                    Double  precio=0.0;
                    String comentario="";
                    int calificacion=0 ;
                    int id_padre=0;
                    String estado="";
                    String curso="";
                    int id_horario=0;
                    int id_servicio=0;
                    int numerohoras=0;

                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idtutoria":
                                idtutoria=jsonReader.nextInt();
                                break;
                            case "hora":
                                SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
                                String prueba=jsonReader.nextString();
                                Date date =  sf.parse(prueba);
                                hora=date;
                                break;
                            case "fecha":
                                SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss");
                                String prueba2=jsonReader.nextString();
                                Date date2 =  sd.parse(prueba2);
                                fecha=date2;
                                break;
                            case "precio":
                                precio=jsonReader.nextDouble();
                                break;
                            case "comentario":
                                comentario=jsonReader.nextString();
                                break;
                            case "calificacion":
                                calificacion=jsonReader.nextInt();
                                break;
                            case "id_padre":
                                id_padre=jsonReader.nextInt();
                                break;
                            case "estado":
                                estado=jsonReader.nextString();
                                break;
                            case "curso":
                                curso=jsonReader.nextString();
                                break;
                            case "id_horario":
                                id_horario=jsonReader.nextInt();
                                break;
                            case "id_servicio":
                                id_servicio=jsonReader.nextInt();
                                break;
                            case "numerohoras":
                                numerohoras=jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Tutoria obj=new Tutoria( idtutoria,  hora,  fecha,  precio,  comentario,  calificacion,  id_padre,  estado,  curso,  id_horario, id_servicio, numerohoras);
                    tutorias.add(obj);
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

        return tutorias;
    }
}
