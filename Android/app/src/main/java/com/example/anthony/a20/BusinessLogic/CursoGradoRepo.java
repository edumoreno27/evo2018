package com.example.anthony.a20.BusinessLogic;

import android.util.JsonReader;

import com.example.anthony.a20.Entities.Cursogrado;
import com.example.anthony.a20.Entities.Profesor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CursoGradoRepo implements ICursoGradoRepo {
    @Override
    public ArrayList<Cursogrado> getCursoGradoes() {
        ArrayList<Cursogrado> cursogradoes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/cursogrado");

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
                   int idcursogrado  =0;
                   String nombre   ="";
                   String contenido  ="";
                   String grado     ="";

                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idcursogrado":
                                idcursogrado=jsonReader.nextInt();
                                break;
                            case "nombre":
                                nombre=jsonReader.nextString();
                                break;
                            case "contenido":
                                contenido=jsonReader.nextString();
                                break;
                            case "grado":
                                grado=jsonReader.nextString();
                                break;

                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Cursogrado obj=new Cursogrado( idcursogrado,nombre,contenido,grado);
                    cursogradoes.add(obj);
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

        return cursogradoes;
    }

    @Override
    public ArrayList<Cursogrado> getCursosDelProfe(int idprofe) {
        ArrayList<Cursogrado> cursogradoes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/cursogrado?idprofe="+idprofe);

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
                    int idcursogrado  =0;
                    String nombre   ="";
                    String contenido  ="";
                    String grado     ="";

                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idcursogrado":
                                idcursogrado=jsonReader.nextInt();
                                break;
                            case "nombre":
                                nombre=jsonReader.nextString();
                                break;
                            case "contenido":
                                contenido=jsonReader.nextString();
                                break;
                            case "grado":
                                grado=jsonReader.nextString();
                                break;

                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Cursogrado obj=new Cursogrado( idcursogrado,nombre,contenido,grado);
                    cursogradoes.add(obj);
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

        return cursogradoes;
    }
}
