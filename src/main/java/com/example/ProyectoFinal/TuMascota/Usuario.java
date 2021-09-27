package com.example.ProyectoFinal.TuMascota;

import java.util.Date;

public class Usuario {

    //Atributos
    private int ID;
    private int ID_COMUNA;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private Date Fecha;
    private String Password;
    private String Genero;
    private String Region;
    private String Comuna;

    //Constructor
    public Usuario(){
    }

    public Usuario(int ID_COMUNA, int ID, String Nombre, String Apellido, String Correo, Date Fecha, String Password, String Genero, String Region, String Comuna){

        this.ID_COMUNA = ID_COMUNA;
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Fecha = Fecha;
        this.Correo = Correo;
        this.Password = Password;
        this.Genero = Genero;
        this.Region = Region;
        this.Comuna = Comuna;

    }


    public Usuario(int ID_COMUNA, int ID, String Nombre, String Apellido, String Correo, Date Fecha,  String Password, String Genero){

        this.ID_COMUNA = ID_COMUNA;
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Fecha = Fecha;
        this.Password = Password;
        this.Genero = Genero;
    }

    //Getters y Setters


    public int getID_COMUNA() {
        return ID_COMUNA;
    }

    public void setID_COMUNA(int ID_COMUNA) {
        this.ID_COMUNA = ID_COMUNA;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getComuna() {
        return Comuna;
    }

    public void setComuna(String comuna) {
        Comuna = comuna;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ID=" + ID +
                ", ID_COMUNA=" + ID_COMUNA +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Correo='" + Correo + '\'' +
                ", Fecha=" + Fecha +
                ", Password='" + Password + '\'' +
                ", Genero='" + Genero + '\'' +
                ", Region='" + Region + '\'' +
                ", Comuna='" + Comuna + '\'' +
                '}';
    }
}



