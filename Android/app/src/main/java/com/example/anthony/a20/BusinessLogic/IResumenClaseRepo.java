package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Padre;
import com.example.anthony.a20.Entities.ResumenClase;

import java.util.ArrayList;

public interface IResumenClaseRepo {
    boolean createResumen(ResumenClase obj);
    ArrayList<ResumenClase> getResumen1(int idtutoria);
    ArrayList<ResumenClase> getResumen2(int idprofe);
}
