package com.example.anthony.a20.Entities;

import org.json.JSONException;
import org.json.JSONObject;

public class Padre {
    private int idpadre ;
    private String nombre ;
    private String apellido;
    private String password ;
    private String email ;
    private String departamento ;
    private String provincia ;
    private String distrito ;
    private String direccion ;
    private int celular ;
    private int dni ;
    private String fotourl;
    public Padre()
    {

    }
    public Padre(int idpadre, String nombre, String apellido, String password, String email, String departamento, String provincia, String distrito, String direccion, int celular, int dni, String fotourl) {
        this.idpadre = idpadre;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.email = email;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.direccion = direccion;
        this.celular = celular;
        this.dni = dni;
        this.fotourl = fotourl;
    }

    public String toJson(){
        String jsonText = null;

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("nombre",getNombre());
            jsonObject.put("apellido", getApellido());
            jsonObject.put("password", getPassword());
            jsonObject.put("email", getEmail());
            jsonObject.put("departamento", getDepartamento());
            jsonObject.put("provincia", getProvincia());
            jsonObject.put("distrito", getDistrito());
            jsonObject.put("direccion", getDireccion());
            jsonObject.put("celular", getCelular());
            jsonObject.put("dni", getDni());
            jsonObject.put("fotourl", getFotourl());

            jsonText = jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonText;
    }

    public int getIdpadre() {
        return idpadre;
    }

    public void setIdpadre(int idpadre) {
        this.idpadre = idpadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFotourl() {
        return fotourl;
    }

    public void setFotourl(String fotourl) {
        this.fotourl = fotourl;
    }
}
