package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Suscripcion;
import com.example.anthony.a20.Entities.Tutoria;

import java.util.ArrayList;

public interface ITutoriaRepo {
    boolean createTutoria(Tutoria obj);
    ArrayList<Tutoria> getTutoriasDelPadre(int idpadre);
    ArrayList<Tutoria> getTutoriasDelProfe(int idprofe);
}
