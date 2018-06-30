package com.example.anthony.a20.Entities;

public class Horario {
    private int idhorario;
    private String horainicio;
    private String horafin;
    private String dia;

    public Horario(int idhorario, String horainicio, String horafin, String dia) {
        this.idhorario = idhorario;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.dia = dia;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
