package com.example.ProyectoFinal.TuMascota;

public class adopcionVista {

    String nombreMascota;
    String estatura;
    int edad;
    String sexo;
    String nombreUsuario;
    String Apellido;
    String correo;
    int id;

    public adopcionVista() {

    }

    public adopcionVista(String nombreMascota, String estatura, int edad, String sexo, String nombreUsuario, String apellido, String correo, int id) {
        this.nombreMascota = nombreMascota;
        this.estatura = estatura;
        this.edad = edad;
        this.sexo = sexo;
        this.nombreUsuario = nombreUsuario;
        this.Apellido = apellido;
        this.correo = correo;
        this.id = id;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
