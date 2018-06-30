package com.example.anthony.a20.BusinessLogic;

import android.util.JsonReader;

import com.example.anthony.a20.Entities.Padre;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PadreRepo implements IPadreRepo{
    @Override
    public Padre getPadre(String email) {
        Padre padres=new Padre();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/padres?email="+email);

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


                    jsonReader.beginObject();
                    int idpadre = 0 ;
                    String nombre ="";
                    String apellido="";
                    String password ="";
                    String email2 ="";
                    String departamento = "" ;
                    String provincia ="";
                    String distrito ="";
                    String direccion ="";
                    int celular =0;
                    int dni =0;
                    String fotourl="";
                    int x=0;
                    while(x<12){
                        x++;
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idpadre":
                                idpadre=jsonReader.nextInt();
                                break;
                            case "nombre":
                                nombre=jsonReader.nextString();
                                break;
                            case "apellido":
                                apellido=jsonReader.nextString();
                                break;
                            case "password":
                                password=jsonReader.nextString();
                                break;
                            case "email":
                                email2=jsonReader.nextString();
                                break;
                            case "departamento":
                                departamento=jsonReader.nextString();
                                break;
                            case "provincia":
                                provincia=jsonReader.nextString();
                                break;
                            case "distrito":
                                distrito=jsonReader.nextString();
                                break;
                            case "direccion":
                                direccion=jsonReader.nextString();
                                break;
                            case "celular":
                                celular=jsonReader.nextInt();
                                break;
                            case "dni":
                                dni=jsonReader.nextInt();
                                break;
                            case "fotourl":
                                fotourl=jsonReader.nextString();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                padres=new Padre(idpadre,nombre,apellido,password,email2,departamento,provincia,distrito,direccion,celular,dni,fotourl);
                    jsonReader.endObject();
                jsonReader.close();
                myConnection.disconnect();

            } else   {

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return padres;

    }

    @Override
    public boolean createPadre(Padre obj) {

        boolean result=false;
        try{
            URL apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/padres");

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
    public  ArrayList<Padre> getPadresDeMensaje(int idprofe) {
        ArrayList<Padre> padres=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/padres?idprofe="+idprofe);

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
                    int idpadre = 0 ;
                    String nombre ="";
                    String apellido="";
                    String password ="";
                    String email2 ="";
                    String departamento = "" ;
                    String provincia ="";
                    String distrito ="";
                    String direccion ="";
                    int celular =0;
                    int dni =0;
                    String fotourl="";
                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idpadre":
                                idpadre=jsonReader.nextInt();
                                break;
                            case "nombre":
                                nombre=jsonReader.nextString();
                                break;
                            case "apellido":
                                apellido=jsonReader.nextString();
                                break;
                            case "password":
                                password=jsonReader.nextString();
                                break;
                            case "email":
                                email2=jsonReader.nextString();
                                break;
                            case "departamento":
                                departamento=jsonReader.nextString();
                                break;
                            case "provincia":
                                provincia=jsonReader.nextString();
                                break;
                            case "distrito":
                                distrito=jsonReader.nextString();
                                break;
                            case "direccion":
                                direccion=jsonReader.nextString();
                                break;
                            case "celular":
                                celular=jsonReader.nextInt();
                                break;
                            case "dni":
                                dni=jsonReader.nextInt();
                                break;
                            case "fotourl":
                                fotourl=jsonReader.nextString();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Padre obj=new Padre(idpadre,nombre,apellido,password,email2,departamento,provincia,distrito,direccion,celular,dni,fotourl);
                    padres.add(obj);
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

        return padres ;
    }
}
