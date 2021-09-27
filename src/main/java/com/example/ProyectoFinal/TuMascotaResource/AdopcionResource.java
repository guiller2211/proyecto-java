package com.example.ProyectoFinal.TuMascotaResource;
import com.example.ProyectoFinal.TuMascota.Adopcion;
import com.example.ProyectoFinal.TuMascota.Regiones;
import com.example.ProyectoFinal.TuMascota.Usuario;
import com.example.ProyectoFinal.TuMascota.UsuarioMascota;
import com.example.ProyectoFinal.TuMascotaDAO.AdopcionDAO;
import com.example.ProyectoFinal.TuMascotaDAO.GeolocalizacionDAO;
import com.example.ProyectoFinal.TuMascotaDAO.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.ProyectoFinal.TuMascota.adopcionVista;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping("/adopcion")
public class AdopcionResource {

    @Autowired
    private AdopcionDAO adopcionDao;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET PARA MOSTRAR LISTA DE ADOPCIONES
    @RequestMapping(method = RequestMethod.GET)
    public List<Adopcion> listaAdopcion() {
        return AdopcionDAO.listaAdopcion();
    }
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //POST PARA CREAR ADOPCION
   @RequestMapping(method = RequestMethod.POST, value = "/crearAdopcion")
   public Adopcion crearAdopcion(@RequestBody Adopcion adopcion){
       int retornoo = adopcionDao.crearAdopcion(adopcion);
       return adopcion;
   }
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////77
    //DELETE PARA ELIMINAR ADOPCION
   //ELIMINAR MASCOTA
   @RequestMapping(method = RequestMethod.DELETE, value = "/eliminarAdopcion/{id}")
   public int eliminarUsuarioMascota(@PathVariable int id){
       int retornar = adopcionDao.eliminarAdopcion(id);
       return retornar;
   }

  /*  @RequestMapping(method = RequestMethod.GET, value="/info/{ID_Usuario}")
    public List<Adopcion> obtenerAdopcion(@PathVariable int ID_Usuario) {
        System.out.println(ID_Usuario);
        return AdopcionDAO.listaAdopciones(ID_Usuario);
    }*/

    @RequestMapping( method = RequestMethod.GET, value="/solicitudes/{id}")
    public List<adopcionVista> listarSolicitudAdopcion(@PathVariable int id){
        return adopcionDao.listarSolicitudAdopcion(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/aceptarSolicitudAdopcion/{id}")
    public int aceptarSolicitudAdopcion(@PathVariable int id){
        int retor = adopcionDao.aceptarSolicitudAdopcion(id);
        return retor;
    }

}