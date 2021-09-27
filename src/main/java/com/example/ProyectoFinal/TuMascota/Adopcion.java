package com.example.ProyectoFinal.TuMascota;

import java.util.Date;

public class Adopcion {

    private int ID;
    private int ID_Mascota;
    private int ID_Usuario;
    private String Estado;

    public Adopcion(){
    }

    public Adopcion(int ID, int ID_Mascota, int ID_Usuario, String Estado) {

        this.ID = ID;
        this.ID_Mascota = ID_Mascota;
        this.ID_Usuario = ID_Usuario;
        this.Estado = Estado;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_Mascota() {
        return ID_Mascota;
    }

    public void setID_Mascota(int ID_Mascota) {
        this.ID_Mascota = ID_Mascota;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }


    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }


    @Override
    public String toString() {
        return "Adopcion{" +
                "ID=" + ID +
                ", ID_Mascota=" + ID_Mascota +
                ", ID_Usuario=" + ID_Usuario +
                ", Estado='" + Estado + '\'' +
                '}';
    }
}

