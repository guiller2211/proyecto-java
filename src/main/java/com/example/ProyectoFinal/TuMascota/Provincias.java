package com.example.ProyectoFinal.TuMascota;

public class Provincias {

    //ATRIBUTOS
    private int ID;
    private String Provincia;
    private int Region_ID;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSTRUCTORES
    public Provincias(){
    }

    public Provincias(int ID, String Provincia, int region_ID) {
        this.ID = ID;
        this.Provincia = Provincia;
        this.Region_ID = Region_ID;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GETTERS Y SETTERS

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }

    public int getRegion_ID() {
        return Region_ID;
    }

    public void setRegion_ID(int region_ID) {
        Region_ID = region_ID;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //METODO TO STRING

    @Override
    public String toString() {
        return "Provincia{" +
                "ID=" + ID +
                ", Provincia=" + Provincia +
                ", Region_ID=" + Region_ID +
                '}';
    }
}
