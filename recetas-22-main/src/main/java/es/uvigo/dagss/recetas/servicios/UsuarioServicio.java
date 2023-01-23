package es.uvigo.dagss.recetas.servicios;


import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.UsuarioEntidad;


public interface UsuarioServicio {

    List<UsuarioEntidad> buscarPorEmail(String email);

    List<UsuarioEntidad> buscarPorNombre(String nombre);

    List<UsuarioEntidad> buscarTodos();

    Optional<UsuarioEntidad> buscarPorLogin(String login);

    void eliminar(UsuarioEntidad usuarioEntidad);

    UsuarioEntidad modificar(UsuarioEntidad usuarioentidad);

    UsuarioEntidad crear(UsuarioEntidad usuarioentidad);


}
