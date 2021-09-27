package com.example.ProyectoFinal.TuMascota;

public class UsuarioMascota {

    //ATRIBUTOS
    private int id;
    private String Nombre;
    private String Estatura;
    private int Edad;
    private String Sexo;
    private String Imagen;
    private String Descripcion;
    private int ID_Comunas;
    private String Region;
    private String Comuna;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSTRUCTORES
    public UsuarioMascota(){
    }

    public UsuarioMascota(int id, String Nombre, String Estatura, int Edad, String Sexo, String Imagen, String Descripcion, int ID_Comunas, String Region, String Comuna){
        this.id = id;
        this.Nombre =  Nombre;
        this.Estatura = Estatura;
        this.Edad = Edad;
        this.Sexo = Sexo;
        this.Imagen = Imagen;
        this.Descripcion = Descripcion;
        this.ID_Comunas = ID_Comunas;
        this.Region = Region;
        this.Comuna = Comuna;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Getters y Setters

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEstatura() {
        return Estatura;
    }

    public void setEstatura(String Estatura) {
        this.Estatura = Estatura;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }


    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getID_Comunas() {
        return ID_Comunas;
    }

    public void setID_Comunas(int ID_Comunas) {
        this.ID_Comunas = ID_Comunas;
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
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //METODO TO STRING
    @Override
    public String toString() {
        return "UsuarioMascota{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Estatura='" + Estatura + '\'' +
                ", Edad=" + Edad +
                ", Sexo='" + Sexo + '\'' +
                ", Imagen='" + Imagen + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", ID_Comunas=" + ID_Comunas +
                ", Region='" + Region + '\'' +
                ", Comuna='" + Comuna + '\'' +
                '}';
    }
}
