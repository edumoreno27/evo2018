package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Cursogrado;
import com.example.anthony.a20.Entities.Zona;

import java.util.ArrayList;

public interface IZonaRepo {
    ArrayList<Zona> getZonaes();
    ArrayList<Zona> getZonasDelProfe(int idprofe);
}
