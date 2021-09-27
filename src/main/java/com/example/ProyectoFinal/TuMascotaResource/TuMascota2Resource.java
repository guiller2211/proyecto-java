package com.example.ProyectoFinal.TuMascotaResource;
import com.example.ProyectoFinal.TuMascotaDAO.TuMascota2DAO;
import com.example.ProyectoFinal.TuMascota.UsuarioMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.synth.Region;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Controller
@RequestMapping("/mascota")
public class TuMascota2Resource {


    @Value("${imagen.directorio}")
    private  String DIRECTORIO;

    @Autowired
    private TuMascota2DAO tuMascota2Dao;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET PARA MOSTAR LISTA DE MASCOTAS
    @RequestMapping( method = RequestMethod.GET)
    public List<UsuarioMascota> listaUsuario(){
        return tuMascota2Dao.listaMascota();
    }

    //GET PARA MOSTAR LISTA DE MASCOTAS
    @RequestMapping( method = RequestMethod.GET, value = "/mascotaID/{id}")
    public List<UsuarioMascota> getMascotaID(@PathVariable int id){
        return tuMascota2Dao.getMascotaID(id);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //POST PARA GUARDAR REGISTRO DE LA MASCOTA
    @PostMapping( value="/guardar", consumes = { "multipart/form-data" })
    public UsuarioMascota crearUsuario(@RequestParam("imageFile") MultipartFile archivo,
                                       @RequestParam("nombre") String nombre,
                                       @RequestParam("estatura") String estatura,
                                       @RequestParam("edad") String edad,
                                       @RequestParam("sexo") String sexo,
                                       @RequestParam("descripcion") String descripcion,
                                       @RequestParam("region") String region,
                                       @RequestParam("comuna") String comuna,
                                       @RequestParam("id_Comuna") String id_Comuna
    ) throws IOException {
        System.out.println(archivo.getOriginalFilename());
        byte[] bytes = archivo.getBytes();

        Path path = Paths.get(DIRECTORIO+ archivo.getOriginalFilename());
        Files.write(path, bytes);

        System.out.println(bytes.length);
        UsuarioMascota mascota= new UsuarioMascota( 0,
                nombre,
                estatura,
                0,
                sexo,
                archivo.getOriginalFilename(),
                descripcion,
                0,
                region,
                comuna);

        int retorno = tuMascota2Dao.crearUsuarioMascota(mascota);

        return mascota;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET PARA MOSTRAR MASCOTA POR REGION, COMUNA, ESTATURA Y SEXO
    @RequestMapping(method = RequestMethod.GET, value = "/mascotaregion")
    public List<UsuarioMascota> busquedaMascota(@RequestParam ("estatura")String estatura, @RequestParam ("sexo")String sexo, @RequestParam ("region") String region, @RequestParam ("comuna") String comuna) {
        System.out.println(estatura);
        System.out.println(sexo);
        return TuMascota2DAO.listaBusqueda(estatura, sexo, region, comuna);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSULTA SI EXISTE MASCOTA POR ID
    @RequestMapping(method = RequestMethod.GET, value = "/consultaMascota/{id}")
    public int consultarUsuarioMascota(@PathVariable int id){
        int retornoo = tuMascota2Dao.usuarioMascotaExiste(id);
        return retornoo;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ACTUALIZAR DATOS MASCOTA
    @RequestMapping(method = RequestMethod.PUT, value = "/editarmascota/{id}")
    public int editarUsuarioMascota(@RequestBody UsuarioMascota editar, @PathVariable int id){
        int retor = tuMascota2Dao.actualizarUsuarioMascota(editar, id);
        return retor;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ELIMINAR MASCOTA
    @RequestMapping(method = RequestMethod.DELETE, value = "/eliminarmascota/{id}")
    public int eliminarUsuarioMascota(@PathVariable int id){
        int retornar = tuMascota2Dao.eliminarUsuarioMascota(id);
        return retornar;
    }
}   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
