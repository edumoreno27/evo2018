package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Cursogrado;

import java.util.ArrayList;

public interface ICursoGradoRepo {
    ArrayList<Cursogrado> getCursoGradoes();
    ArrayList<Cursogrado> getCursosDelProfe(int idprofe);
}
