package com.example.ProyectoFinal.TuMascotaResource;
import com.example.ProyectoFinal.TuMascota.Comunas;
import com.example.ProyectoFinal.TuMascota.Provincias;
import com.example.ProyectoFinal.TuMascota.Regiones;
import com.example.ProyectoFinal.TuMascotaDAO.GeolocalizacionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Controller
@RequestMapping("/geolocalizacion")
public class GeolocalizacionResource {


    @Autowired
    private GeolocalizacionDAO geolocalizacionDao;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET PARA MOSTRAR LISTA DE REGIONES
    @RequestMapping(method = RequestMethod.GET)
    public List<Regiones> listaRegiones() {
        return GeolocalizacionDAO.listaRegiones();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GERT PARA MOSTRAR LISTA DE COMUNAS SEGUN REGION
    @RequestMapping(method = RequestMethod.GET, value = "/R_C")
    public List<Comunas> listaComuna2(@RequestParam("Region_ID")int Region_ID) {
        return GeolocalizacionDAO.listaComunas2(Region_ID);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET PARA MOSTRAR LISTA DE PROVINCIAS
    @RequestMapping(method = RequestMethod.GET, value = "/provincia")
    public List<Provincias> listaProvincia() {
        return GeolocalizacionDAO.listaProvincias();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET PARA MOSTRAR LISTA DE COMUNAS
    @RequestMapping(method = RequestMethod.GET, value= "/comuna")
    public List<Comunas> listaComunas() {
        return GeolocalizacionDAO.listaComunas();
    }
}