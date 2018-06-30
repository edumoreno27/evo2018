package com.example.anthony.a20.BusinessLogic;

import com.example.anthony.a20.Entities.Mensaje;
import com.example.anthony.a20.Entities.MetodoPago;

public interface IMetodoPagoRepo {
    boolean createMetodoPago(MetodoPago obj);
    MetodoPago getMetodoPago(int id);
}
