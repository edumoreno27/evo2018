package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Cursogrado;
import com.example.anthony.a20.Entities.Horario;

import java.util.ArrayList;

public interface IHorarioRepo {
    ArrayList<Horario> getHorarios();
    ArrayList<Horario> getHorariosDelProfe(int idprofe);
    ArrayList<Horario> getHorariosDelProfe2(int idprofe,String estado);

}
