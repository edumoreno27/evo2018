package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Mensaje;

import java.util.ArrayList;

public interface IMensajeRepo {
    Mensaje getMensaje(int id);
    ArrayList<Mensaje> getMensajes(int idpadre,int idprofe);
    boolean createMensaje(Mensaje obj);
}
