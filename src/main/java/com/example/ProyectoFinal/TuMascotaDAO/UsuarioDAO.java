package com.example.ProyectoFinal.TuMascotaDAO;
import com.example.ProyectoFinal.TuMascota.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class UsuarioDAO {

    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public UsuarioDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //MOSTRAR LISTA COMPLETA USUARIOS
    public static List<Usuario> list() {
        String sqlConsulta = "SELECT * FROM Usuario";
        List<Usuario> usuarios = jdbcTemplate.query(sqlConsulta, BeanPropertyRowMapper.newInstance(Usuario.class));
        return usuarios;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //SELECCIONAR USUARIO DONDE CORREO SEA?
    public boolean usuarioExisteCorreo(String Correo) {
        String sql = "SELECT count(*) FROM Usuario where Correo = ?";
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Usuario where Correo = ?",new Object[] { Correo }, Integer.class);
        return result>0;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //REGISTRO USUARIO
    public int crearUsuario(Usuario usuario) {
        String sqlcrear = "INSERT INTO Usuario ( Nombre, Apellido, Fecha, Correo, Password, Genero, ID_COMUNA, Region, Comuna) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int resultado = jdbcTemplate.update(sqlcrear, usuario.getNombre(), usuario.getApellido(), usuario.getFecha(), usuario.getCorreo(), usuario.getPassword(), usuario.getGenero(), usuario.getID_COMUNA(), usuario.getRegion(), usuario.getComuna());
        return resultado;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSULTA SI USUARIO EXISTE
    public Usuario usuarioExiste(String Correo, String Password) {
        String sql = "SELECT * FROM Usuario WHERE Correo = ? and Password = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{Correo, Password},(rs, rowNum) ->
                new Usuario(
                        rs.getInt("ID_COMUNA"),
                        rs.getInt("ID"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Correo"),
                        rs.getDate("Fecha"),
                        rs.getString("Genero"),
                        rs.getString("Password"),
                        rs.getString("Region"),
                        rs.getString("Comuna")));

    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSULTA USUARIO EXISTE POR ID
    public Usuario usuarioId(int ID) {
        String sql = "SELECT * FROM Usuario WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{ID},(rs, rowNum) ->
                new Usuario(
                        rs.getInt("ID_COMUNA"),
                        rs.getInt("ID"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Correo"),
                        rs.getDate("Fecha"),
                        rs.getString("Genero"),
                        rs.getString("Password"),
                        rs.getString("Region"),
                        rs.getString("Comuna")));

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ACTUALIZAR CONTRASEÑA USUARIO
    public boolean actualizarContraseña(Usuario editar, String Correo) {
        String sqleditar = "UPDATE Usuario set Password =? where Correo = ? ";
        int results = jdbcTemplate.update(sqleditar, editar.getPassword(),Correo);

        return results>0;
    }

    //ACTUALIZAR DATOS USUARIO
    public boolean actualizarUsuario(Usuario editar, String Correo) {
        String sqleditar = "UPDATE Usuario set Nombre = ?, Apellido = ?, Fecha = ?, Correo = ?, Password = ?, Genero = ?, Region = ?, Comuna = ? where Correo = ? ";
        int results = jdbcTemplate.update(sqleditar, editar.getNombre(), editar.getApellido(), editar.getFecha(), editar.getCorreo(), editar.getPassword(), editar.getGenero(), editar.getRegion(), editar.getComuna(), Correo);
        return results>0;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ELIMINAR USUARIO
    public int eliminarUsuario(String correo) {
        String sqleliminar = "DELETE FROM Usuario WHERE correo =?";
        int resulta = jdbcTemplate.update(sqleliminar, correo);
        return resulta;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSULTAR USUARIO
    public static List<Usuario> consultarUsuario(int id) {
        String sqlConsulta = "SELECT * FROM usuario WHERE ID =?";
        return jdbcTemplate.query(sqlConsulta, new Object[]{id}, (rs, rowNum) ->
                new Usuario(
                        rs.getInt("id_comuna"),
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getDate("fecha"),
                        rs.getString("password"),
                        rs.getString("genero")
                )
        );
    }

}

