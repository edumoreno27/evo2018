package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.ProfeCursoGrado;
import com.example.anthony.a20.Entities.ProfeHorario;

import java.util.ArrayList;

public interface IProfeHorarioRepo {
    boolean createProfeHorario(ProfeHorario obj);
    ArrayList<ProfeHorario> get(int id1,int id2);
}
