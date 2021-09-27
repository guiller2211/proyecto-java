package com.example.ProyectoFinal.TuMascotaDAO;
import com.example.ProyectoFinal.TuMascota.Adopcion;
import com.example.ProyectoFinal.TuMascota.UsuarioMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.ProyectoFinal.TuMascota.adopcionVista;

import java.sql.ResultSet;
import java.util.List;

@Repository
@Transactional
public class AdopcionDAO {

    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public AdopcionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //MOSTRAR LISTA DE ADOPCIONES
    public static List<Adopcion> listaAdopcion() {
        String sql = "SELECT * FROM Adopcion";
        List<Adopcion> adopciones = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adopcion.class));
        return adopciones;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CREAR REGISTRO PARA ADOPCION
    public int crearAdopcion(Adopcion adopcion) {
        String sqlcrear = "INSERT INTO Adopcion (ID_Mascota, ID_Usuario, Estado) VALUES (?,?,?)";
        int resultado = jdbcTemplate.update(sqlcrear,adopcion.getID_Mascota(), adopcion.getID_Usuario(), adopcion.getEstado());
        return resultado;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ELIMINAR ADOPCION
    public int eliminarAdopcion(int id) {
        String sqleliminar = "DELETE FROM Adopcion WHERE id =?";
        int resulta = jdbcTemplate.update(sqleliminar, id);
        return resulta;
    }
    //////////////////////////////////////////////////////////////////////////////
    /*public static List<Adopcion> listaAdopciones(int ID_Usuario){
        String SQLconsulta = "select ms.Nombre,ms.Estatura,ms.Edad,ms.Sexo, usadp.Nombre,usadp.Apellido,usadp.Correo,adp.ID from dbo.Usuario us inner join dbo.Mascota ms on us.id = ms.id_usuario Inner Join dbo.Adopcion adp on ms.id = adp.ID_Mascota Inner Join dbo.Usuario usadp on adp.id_Usuario = usadp.id where us.id = ?" ;
        List<Adopcion> busquedaMascota = jdbcTemplate.query(SQLconsulta, new Object[]{ID_Usuario}, (rs, rowNum) ->
        new Adopcion(
                rs.getInt("ID"),
                rs.getInt("ID_Mascota"),
                rs.getInt("ID_Usuario"),
                rs.getString("Estado")
        )
        );
        return busquedaMascota;
    }*/

    public List<adopcionVista> listarSolicitudAdopcion (int idUsuario){
        String SQLconsulta = "select ms.Nombre as nombreMascota,ms.Estatura as estatura,ms.Edad as edad,ms.Sexo as sexo, usadp.Nombre as nombreUsuario,usadp.Apellido as apellido,usadp.Correo as correo,adp.ID as id from dbo.Usuario us  inner join dbo.Mascota ms on us.id = ms.id_usuario Inner Join dbo.Adopcion adp on ms.id = adp.ID_Mascota Inner Join dbo.Usuario usadp on adp.id_Usuario = usadp.id where us.id = ? and adp.estado='Solicitada'";
        List<adopcionVista> adopcionVista = jdbcTemplate.query(SQLconsulta, new Object[]{idUsuario}, new BeanPropertyRowMapper<>(adopcionVista.class));
        return adopcionVista;
    }

    public int aceptarSolicitudAdopcion (int idSolicitud){


        // Validar que la mascota no haya sido adoptada antes
        String SQLValidacion = "SELECT count(*) as c FROM dbo.adopcion adp where id_mascota = (SELECT id_mascota from dbo.adopcion where id = ?) and estado = 'Aceptada'";
        int validacion = (Integer) jdbcTemplate.queryForObject(SQLValidacion, new Object[]{idSolicitud}, Integer.class);

        // Si el count devuelve un registro es porque la mascota ya tiene una adopcion aceptada
        if (validacion != 0){
            return 0;

            // si el count devuelve 0, la mascota no tiene solicitud aceptada, entonces entra a aceptar
        }else{// count(*) = 0
            // Acepto la solicitud
            String sqleditar = "UPDATE dbo.Adopcion set estado = 'Aceptada' where ID = ? ";
            int resulta = jdbcTemplate.update(sqleditar, new Object[]{idSolicitud});

            // Cancelo las demas solicitudes de la mascota, ya que fue aceptada la solicitud
            if (resulta == 1) {
                String sqlCancelar = "UPDATE dbo.Adopcion set estado = 'Cancelada' WHERE id_mascota = (SELECT distinct id_mascota from dbo.adopcion where id = ?) and id <> ?";
                jdbcTemplate.update(sqlCancelar, new Object[]{idSolicitud, idSolicitud});
            }
            return resulta;
        }
    }
}