package com.example.ProyectoFinal.TuMascotaResource;


import com.example.ProyectoFinal.Service.CorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
public class CorreoResource {

    @Autowired
    private CorreoService correoService;

    //ENVIAR BIENVENIDA
    @GetMapping(path = "/enviarBienvenida/{id}")
    public void enviarBienvenida(@PathVariable int id){
        correoService.enviarBienvenida(id);
    }
}
