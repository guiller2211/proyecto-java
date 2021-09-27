package com.example.ProyectoFinal.TuMascota;

public class Comunas {

    //ATRIBUTOS
    private int ID;
    private String Comuna;
    private int Provincia_ID;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSTRUCTORES
    public Comunas(){
    }

    public Comunas(int ID, String Comuna, int provincia_ID) {
        this.ID = ID;
        this.Comuna = Comuna;
        this.Provincia_ID = Provincia_ID;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GETTERS Y SETTERS

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String comuna) {
        Comuna = comuna;
    }

    public int getProvincia_ID() {
        return Provincia_ID;
    }

    public void setProvincia_ID(int provincia_ID) {
        Provincia_ID = provincia_ID;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //METODO TO STRING

    @Override
    public String toString() {
        return "Comuna{" +
                "ID=" + ID +
                ", Comuna='" + Comuna + '\'' +
                ", Provincia_ID='" + Provincia_ID + '\'' +
                '}';
    }
}
