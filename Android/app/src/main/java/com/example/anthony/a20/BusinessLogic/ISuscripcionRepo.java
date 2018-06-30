package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Servicio;
import com.example.anthony.a20.Entities.Suscripcion;

import java.util.ArrayList;

public interface ISuscripcionRepo {
    boolean createSuscripcion(Suscripcion obj);
    ArrayList<Suscripcion> getSuscripcions(int idprofesor);
}
