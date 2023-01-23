package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.Usuario;

public interface UsuarioServicio {

    List<Usuario> buscarTodos();

    Optional<Usuario> buscarPorLogin(String login);

    void eliminar(Usuario usuarioEntidad);

    Usuario modificar(Usuario usuarioentidad);

    Usuario crear(Usuario usuarioentidad);

}
