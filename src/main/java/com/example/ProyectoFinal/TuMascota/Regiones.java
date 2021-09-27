package com.example.ProyectoFinal.TuMascota;

public class Regiones {

    //ATRIBUTOS
    private int ID;
    private String Region;
    private String Abreviatura;
    private String Capital;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSTRUCTORES
    public Regiones(){
    }

    public Regiones(int ID, String Region, String Abreviatura, String Capital) {
        this.ID = ID;
        this.Region = Region;
        this.Abreviatura = Abreviatura;
        this.Capital = Capital;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GETTERS Y SETTERS

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getAbreviatura() {
        return Abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        Abreviatura = abreviatura;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //METODO TO STRING
    @Override
    public String toString() {
        return "Regiones{" +
                "ID=" + ID +
                ", Region='" + Region + '\'' +
                ", Abreviatura='" + Abreviatura + '\'' +
                ", Capital='" + Capital + '\'' +
                '}';
    }
}
