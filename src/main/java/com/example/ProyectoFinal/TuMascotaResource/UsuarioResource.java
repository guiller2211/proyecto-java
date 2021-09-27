package com.example.ProyectoFinal.TuMascotaResource;
import com.example.ProyectoFinal.Service.CorreoService;
import com.example.ProyectoFinal.TuMascotaDAO.UsuarioDAO;
import com.example.ProyectoFinal.TuMascota.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioDAO usuarioDao;
    @Autowired
    private CorreoService correoService;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GET PARA MOSTAR DATOS DE USUARIOS
    @RequestMapping(method = RequestMethod.GET)
    public List<Usuario> obtenerUsuario() {
        return UsuarioDAO.list();
    }

    //////////////////////////////////////ooo/////////////////////////////////////////////////////////////////////////////////
    //GET PARA MEDIANTE CORREO ENVIAR UN LINK PARA CAMBIAR CONTRASEÑA
    @RequestMapping(method = RequestMethod.GET, value = "/consulta/{Correo}")
    public boolean consultarUsuario(@PathVariable String Correo) {
        correoService.recuperarPassword(Correo);
        return usuarioDao.usuarioExisteCorreo(Correo);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //POST PARA CREAR USUARIO Y ENVIAR CORREO BIENVENIDA
    @RequestMapping(method = RequestMethod.POST, value = "/addusuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {

        System.out.println(usuario);

        int retorno = usuarioDao.crearUsuario(usuario);
        correoService.enviarBienvenidafromcorreo(usuario);
        return usuario;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSULTA SI EXISTE USUARIO POR CORREO Y CONTRASEÑA PARA HACER EL LOGIN
    @RequestMapping(method = RequestMethod.POST, value = "/consultaUsuario/{Correo}")
    public Usuario consultaUsuario(@PathVariable("Correo") String Correo, @RequestBody() String Password) {
        return usuarioDao.usuarioExiste(Correo, Password);
    }

    //CONSULTA SI EXISTE USUARIO POR ID PARA LUEGO MOSTRAR SUS DATOS
    @RequestMapping(method = RequestMethod.GET, value = "/consultaId/{ID}")
    public Usuario misDatos(@PathVariable("ID") int ID) {
        return usuarioDao.usuarioId(ID);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ACTUALIZAR USUARIO
    @RequestMapping(method = RequestMethod.PUT, value = "/editarcontraseña/{correo}")
    public boolean editarContraseña(@RequestBody Usuario editar, @PathVariable String correo) {
        correoService.recuperarPassword(correo);
        return usuarioDao.actualizarContraseña(editar, correo);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/editarusuario/{correo}")
    public boolean editarUsuario(@RequestBody Usuario editar, @PathVariable String correo) {
        return usuarioDao.actualizarUsuario(editar, correo);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ELIMINAR USUARIO
    @RequestMapping(method = RequestMethod.DELETE, value = "/eliminarusuario/{correo}")
    public int eliminarUsuario(@PathVariable String correo) {
        int retornar = usuarioDao.eliminarUsuario(correo);
        return retornar;
    }
}
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


