package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.ProfeZona;
import com.example.anthony.a20.Entities.Servicio;

public interface IServicioRepo {
    boolean createServicio(Servicio obj);
    Servicio getServicio(int id);
}
