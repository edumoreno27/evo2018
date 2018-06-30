package com.example.anthony.a20.BusinessLogic;

import android.util.JsonReader;


import com.example.anthony.a20.Entities.Profesor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ProfeRepo implements IProfeRepo {
    @Override
    public Profesor getProfesor(String email) {
        Profesor profe=new Profesor();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesors?email="+email);

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


                //Leer cada objeto
                jsonReader.beginObject();
                int idprofesor     =0     ;
                String nombre        =""   ;
                String apellido      =""   ;
                String password      =""   ;
                String email2        =""    ;
                String celular       =""   ;
                String descripcion   =""   ;
                Double preciomin     =0.0     ;
                Double preciomax     =0.0     ;
                String  experiencia    ="" ;
                long calificacion      =0  ;
                long dni               =0  ;
                String antecedentes   =""  ;
                String fotourl        =""      ;
                int id_metodopago     =0 ;
                int x=0;
                while(x<15){
                    x++;
                    String property=jsonReader.nextName();
                    switch(property.toLowerCase()){
                        case "idprofesor":
                            idprofesor=jsonReader.nextInt();
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
                        case "celular":
                            celular=jsonReader.nextString();
                            break;
                        case "descripcion":
                            descripcion=jsonReader.nextString();
                            break;
                        case "preciomin":
                            preciomin=jsonReader.nextDouble();
                            break;
                        case "preciomax":
                            preciomax=jsonReader.nextDouble();
                            break;
                        case "calificacion":
                            calificacion=jsonReader.nextLong();
                            break;
                        case "dni":
                            dni=jsonReader.nextLong();
                            break;
                        case "antecedentes":
                            antecedentes=jsonReader.nextString();
                            break;
                        case "fotourl":
                            fotourl=jsonReader.nextString();
                            break;
                        case "id_metodopago":
                            id_metodopago=jsonReader.nextInt();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                    //Agregar item a la lista
                }
                profe=new Profesor( idprofesor,  nombre,  apellido,  password,  email2,  celular,  descripcion,  preciomin,  preciomax,  experiencia,  calificacion,  dni,  antecedentes,  fotourl,  id_metodopago);
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

        return profe;
    }

    @Override
    public ArrayList<Profesor> getProfesors() {
        ArrayList<Profesor> profes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesors");

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
                    int idprofesor     =0     ;
                    String nombre        =""   ;
                    String apellido      =""   ;
                    String password      =""   ;
                    String email2        =""    ;
                    String celular       =""   ;
                    String descripcion   =""   ;
                    Double preciomin     =0.0     ;
                    Double preciomax     =0.0     ;
                    String  experiencia    ="" ;
                    long calificacion      =0  ;
                    long dni               =0  ;
                    String antecedentes   =""  ;
                    String fotourl        =""      ;
                    int id_metodopago     =0 ;
                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idprofesor":
                                idprofesor=jsonReader.nextInt();
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
                            case "celular":
                                celular=jsonReader.nextString();
                                break;
                            case "descripcion":
                                descripcion=jsonReader.nextString();
                                break;
                            case "preciomin":
                                preciomin=jsonReader.nextDouble();
                                break;
                            case "preciomax":
                                preciomax=jsonReader.nextDouble();
                                break;
                            case "calificacion":
                                calificacion=jsonReader.nextLong();
                                break;
                            case "dni":
                                dni=jsonReader.nextLong();
                                break;
                            case "antecedentes":
                                antecedentes=jsonReader.nextString();
                                break;
                            case "fotourl":
                                fotourl=jsonReader.nextString();
                                break;
                            case "id_metodopago":
                                id_metodopago=jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Profesor obj=new Profesor( idprofesor,  nombre,  apellido,  password,  email2,  celular,  descripcion,  preciomin,  preciomax,  experiencia,  calificacion,  dni,  antecedentes,  fotourl,  id_metodopago);
                    profes.add(obj);
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

        return profes;
    }

    @Override
    public boolean createProfesor(Profesor obj) {
        boolean result=false;
        try{
            URL apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesors");

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
    public ArrayList<Profesor> getProfesorsNoUser(int iduser) {
        ArrayList<Profesor> profes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesors?iduser="+iduser);

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
                    int idprofesor     =0     ;
                    String nombre        =""   ;
                    String apellido      =""   ;
                    String password      =""   ;
                    String email2        =""    ;
                    String celular       =""   ;
                    String descripcion   =""   ;
                    Double preciomin     =0.0     ;
                    Double preciomax     =0.0     ;
                    String  experiencia    ="" ;
                    long calificacion      =0  ;
                    long dni               =0  ;
                    String antecedentes   =""  ;
                    String fotourl        =""      ;
                    int id_metodopago     =0 ;
                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idprofesor":
                                idprofesor=jsonReader.nextInt();
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
                            case "celular":
                                celular=jsonReader.nextString();
                                break;
                            case "descripcion":
                                descripcion=jsonReader.nextString();
                                break;
                            case "preciomin":
                                preciomin=jsonReader.nextDouble();
                                break;
                            case "preciomax":
                                preciomax=jsonReader.nextDouble();
                                break;
                            case "calificacion":
                                calificacion=jsonReader.nextLong();
                                break;
                            case "dni":
                                dni=jsonReader.nextLong();
                                break;
                            case "antecedentes":
                                antecedentes=jsonReader.nextString();
                                break;
                            case "fotourl":
                                fotourl=jsonReader.nextString();
                                break;
                            case "id_metodopago":
                                id_metodopago=jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Profesor obj=new Profesor( idprofesor,  nombre,  apellido,  password,  email2,  celular,  descripcion,  preciomin,  preciomax,  experiencia,  calificacion,  dni,  antecedentes,  fotourl,  id_metodopago);
                    profes.add(obj);
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

        return profes;
    }

    @Override
    public ArrayList<Profesor> getProfesorByZona(int idzona, int iduser) {
        ArrayList<Profesor> profes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesors?idzona="+idzona+"&iduser="+iduser);

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
                    int idprofesor     =0     ;
                    String nombre        =""   ;
                    String apellido      =""   ;
                    String password      =""   ;
                    String email2        =""    ;
                    String celular       =""   ;
                    String descripcion   =""   ;
                    Double preciomin     =0.0     ;
                    Double preciomax     =0.0     ;
                    String  experiencia    ="" ;
                    long calificacion      =0  ;
                    long dni               =0  ;
                    String antecedentes   =""  ;
                    String fotourl        =""      ;
                    int id_metodopago     =0 ;
                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idprofesor":
                                idprofesor=jsonReader.nextInt();
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
                            case "celular":
                                celular=jsonReader.nextString();
                                break;
                            case "descripcion":
                                descripcion=jsonReader.nextString();
                                break;
                            case "preciomin":
                                preciomin=jsonReader.nextDouble();
                                break;
                            case "preciomax":
                                preciomax=jsonReader.nextDouble();
                                break;
                            case "calificacion":
                                calificacion=jsonReader.nextLong();
                                break;
                            case "dni":
                                dni=jsonReader.nextLong();
                                break;
                            case "antecedentes":
                                antecedentes=jsonReader.nextString();
                                break;
                            case "fotourl":
                                fotourl=jsonReader.nextString();
                                break;
                            case "id_metodopago":
                                id_metodopago=jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Profesor obj=new Profesor( idprofesor,  nombre,  apellido,  password,  email2,  celular,  descripcion,  preciomin,  preciomax,  experiencia,  calificacion,  dni,  antecedentes,  fotourl,  id_metodopago);
                    profes.add(obj);
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

        return profes;
    }

    @Override
    public ArrayList<Profesor> getProfesorByGrado(int idcurso, int iduser) {
        ArrayList<Profesor> profes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesors?idcurso="+idcurso+"&iduser="+iduser);

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
                    int idprofesor     =0     ;
                    String nombre        =""   ;
                    String apellido      =""   ;
                    String password      =""   ;
                    String email2        =""    ;
                    String celular       =""   ;
                    String descripcion   =""   ;
                    Double preciomin     =0.0     ;
                    Double preciomax     =0.0     ;
                    String  experiencia    ="" ;
                    long calificacion      =0  ;
                    long dni               =0  ;
                    String antecedentes   =""  ;
                    String fotourl        =""      ;
                    int id_metodopago     =0 ;
                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idprofesor":
                                idprofesor=jsonReader.nextInt();
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
                            case "celular":
                                celular=jsonReader.nextString();
                                break;
                            case "descripcion":
                                descripcion=jsonReader.nextString();
                                break;
                            case "preciomin":
                                preciomin=jsonReader.nextDouble();
                                break;
                            case "preciomax":
                                preciomax=jsonReader.nextDouble();
                                break;
                            case "calificacion":
                                calificacion=jsonReader.nextLong();
                                break;
                            case "dni":
                                dni=jsonReader.nextLong();
                                break;
                            case "antecedentes":
                                antecedentes=jsonReader.nextString();
                                break;
                            case "fotourl":
                                fotourl=jsonReader.nextString();
                                break;
                            case "id_metodopago":
                                id_metodopago=jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Profesor obj=new Profesor( idprofesor,  nombre,  apellido,  password,  email2,  celular,  descripcion,  preciomin,  preciomax,  experiencia,  calificacion,  dni,  antecedentes,  fotourl,  id_metodopago);
                    profes.add(obj);
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

        return profes;
    }

    @Override
    public ArrayList<Profesor> getProfesorFavorito(int idpadre) {
        ArrayList<Profesor> profes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesors?idpadre="+idpadre);

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
                    int idprofesor     =0     ;
                    String nombre        =""   ;
                    String apellido      =""   ;
                    String password      =""   ;
                    String email2        =""    ;
                    String celular       =""   ;
                    String descripcion   =""   ;
                    Double preciomin     =0.0     ;
                    Double preciomax     =0.0     ;
                    String  experiencia    ="" ;
                    long calificacion      =0  ;
                    long dni               =0  ;
                    String antecedentes   =""  ;
                    String fotourl        =""      ;
                    int id_metodopago     =0 ;
                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idprofesor":
                                idprofesor=jsonReader.nextInt();
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
                            case "celular":
                                celular=jsonReader.nextString();
                                break;
                            case "descripcion":
                                descripcion=jsonReader.nextString();
                                break;
                            case "preciomin":
                                preciomin=jsonReader.nextDouble();
                                break;
                            case "preciomax":
                                preciomax=jsonReader.nextDouble();
                                break;
                            case "calificacion":
                                calificacion=jsonReader.nextLong();
                                break;
                            case "dni":
                                dni=jsonReader.nextLong();
                                break;
                            case "antecedentes":
                                antecedentes=jsonReader.nextString();
                                break;
                            case "fotourl":
                                fotourl=jsonReader.nextString();
                                break;
                            case "id_metodopago":
                                id_metodopago=jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Profesor obj=new Profesor( idprofesor,  nombre,  apellido,  password,  email2,  celular,  descripcion,  preciomin,  preciomax,  experiencia,  calificacion,  dni,  antecedentes,  fotourl,  id_metodopago);
                    profes.add(obj);
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

        return profes;
    }

    @Override
    public ArrayList<Profesor> getProfesorConAntecedentes(int idusuario) {
        ArrayList<Profesor> profes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesors?idusuario="+idusuario);

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
                    int idprofesor     =0     ;
                    String nombre        =""   ;
                    String apellido      =""   ;
                    String password      =""   ;
                    String email2        =""    ;
                    String celular       =""   ;
                    String descripcion   =""   ;
                    Double preciomin     =0.0     ;
                    Double preciomax     =0.0     ;
                    String  experiencia    ="" ;
                    long calificacion      =0  ;
                    long dni               =0  ;
                    String antecedentes   =""  ;
                    String fotourl        =""      ;
                    int id_metodopago     =0 ;
                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idprofesor":
                                idprofesor=jsonReader.nextInt();
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
                            case "celular":
                                celular=jsonReader.nextString();
                                break;
                            case "descripcion":
                                descripcion=jsonReader.nextString();
                                break;
                            case "preciomin":
                                preciomin=jsonReader.nextDouble();
                                break;
                            case "preciomax":
                                preciomax=jsonReader.nextDouble();
                                break;
                            case "calificacion":
                                calificacion=jsonReader.nextLong();
                                break;
                            case "dni":
                                dni=jsonReader.nextLong();
                                break;
                            case "antecedentes":
                                antecedentes=jsonReader.nextString();
                                break;
                            case "fotourl":
                                fotourl=jsonReader.nextString();
                                break;
                            case "id_metodopago":
                                id_metodopago=jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Profesor obj=new Profesor( idprofesor,  nombre,  apellido,  password,  email2,  celular,  descripcion,  preciomin,  preciomax,  experiencia,  calificacion,  dni,  antecedentes,  fotourl,  id_metodopago);
                    profes.add(obj);
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

        return profes;
    }

    @Override
    public ArrayList<Profesor> getProfesorConChat(int idfather) {
        ArrayList<Profesor> profes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesors?idfather="+idfather);

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
                    int idprofesor     =0     ;
                    String nombre        =""   ;
                    String apellido      =""   ;
                    String password      =""   ;
                    String email2        =""    ;
                    String celular       =""   ;
                    String descripcion   =""   ;
                    Double preciomin     =0.0     ;
                    Double preciomax     =0.0     ;
                    String  experiencia    ="" ;
                    long calificacion      =0  ;
                    long dni               =0  ;
                    String antecedentes   =""  ;
                    String fotourl        =""      ;
                    int id_metodopago     =0 ;
                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idprofesor":
                                idprofesor=jsonReader.nextInt();
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
                            case "celular":
                                celular=jsonReader.nextString();
                                break;
                            case "descripcion":
                                descripcion=jsonReader.nextString();
                                break;
                            case "preciomin":
                                preciomin=jsonReader.nextDouble();
                                break;
                            case "preciomax":
                                preciomax=jsonReader.nextDouble();
                                break;
                            case "calificacion":
                                calificacion=jsonReader.nextLong();
                                break;
                            case "dni":
                                dni=jsonReader.nextLong();
                                break;
                            case "antecedentes":
                                antecedentes=jsonReader.nextString();
                                break;
                            case "fotourl":
                                fotourl=jsonReader.nextString();
                                break;
                            case "id_metodopago":
                                id_metodopago=jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Profesor obj=new Profesor( idprofesor,  nombre,  apellido,  password,  email2,  celular,  descripcion,  preciomin,  preciomax,  experiencia,  calificacion,  dni,  antecedentes,  fotourl,  id_metodopago);
                    profes.add(obj);
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

        return profes;
    }

    @Override
    public Profesor getProfesor2(int id) {
        Profesor profe=new Profesor();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://vmdev1.nexolink.com:90/TeachersAPI/api/profesors?id="+id);

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


                    //Leer cada objeto
                jsonReader.beginObject();
                    int idprofesor     =0     ;
                    String nombre        =""   ;
                    String apellido      =""   ;
                    String password      =""   ;
                    String email2        =""    ;
                    String celular       =""   ;
                    String descripcion   =""   ;
                    Double preciomin     =0.0     ;
                    Double preciomax     =0.0     ;
                    String  experiencia    ="" ;
                    long calificacion      =0  ;
                    long dni               =0  ;
                    String antecedentes   =""  ;
                    String fotourl        =""      ;
                    int id_metodopago     =0 ;
                    int x=0;
                    while(x<15){
                        x++;
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idprofesor":
                                idprofesor=jsonReader.nextInt();
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
                            case "celular":
                                celular=jsonReader.nextString();
                                break;
                            case "descripcion":
                                descripcion=jsonReader.nextString();
                                break;
                            case "preciomin":
                                preciomin=jsonReader.nextDouble();
                                break;
                            case "preciomax":
                                preciomax=jsonReader.nextDouble();
                                break;
                            case "calificacion":
                                calificacion=jsonReader.nextLong();
                                break;
                            case "dni":
                                dni=jsonReader.nextLong();
                                break;
                            case "antecedentes":
                                antecedentes=jsonReader.nextString();
                                break;
                            case "fotourl":
                                fotourl=jsonReader.nextString();
                                break;
                            case "id_metodopago":
                                id_metodopago=jsonReader.nextInt();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista
                }
                profe=new Profesor( idprofesor,  nombre,  apellido,  password,  email2,  celular,  descripcion,  preciomin,  preciomax,  experiencia,  calificacion,  dni,  antecedentes,  fotourl,  id_metodopago);
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

        return profe;
    }


}
