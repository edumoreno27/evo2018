package com.example.anthony.a20.BusinessLogic;


import com.example.anthony.a20.Entities.ProfeFavorito;

import java.util.ArrayList;

public interface IProfeFavoritoRepo {
    boolean createProfeFavorito(ProfeFavorito obj);
    ArrayList<ProfeFavorito> get(int idpadre, int idprofe);
}
