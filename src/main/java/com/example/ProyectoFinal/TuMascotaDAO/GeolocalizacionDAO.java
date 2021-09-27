package com.example.ProyectoFinal.TuMascotaDAO;
import com.example.ProyectoFinal.TuMascota.Comunas;
import com.example.ProyectoFinal.TuMascota.Provincias;
import com.example.ProyectoFinal.TuMascota.Regiones;
import com.example.ProyectoFinal.TuMascota.UsuarioMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GeolocalizacionDAO {

    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public GeolocalizacionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //MOSTRAR LISTA COMPLETA DE REGIONES
    public static List<Regiones> listaRegiones() {
        String sql = "SELECT * FROM Regiones";
        List<Regiones> regiones = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Regiones.class));
        return regiones;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //MOSTRAR LISTA COMPLETA COMUNAS
    public static List<Comunas> listaComunas2(int Region_ID) {
        String sql = "SELECT * FROM Comunas where Provincia_ID in (select ID from Provincias p2 where Region_ID = ?)";
        List<Comunas> comunas = jdbcTemplate.query(sql, new Object[]{Region_ID}, (rs, rowNum) ->
                new Comunas(
                        rs.getInt("ID"),
                        rs.getString("Comuna"),
                        rs.getInt("Provincia_ID")

                )
        );
        return comunas;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //MOSTRAR LISTA COMPLETA REGIONES
    public static List<Provincias> listaProvincias() {
        String sql = "SELECT * FROM Provincias";
        List<Provincias> provincias = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Provincias.class));
        return provincias;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//MOSTRAR LISTA COMPLETA DE REGIONES
    public static List<Comunas> listaComunas() {
        String sql = "SELECT * FROM Comunas";
        List<Comunas> comunas = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Comunas.class));
        return comunas;
    }
}