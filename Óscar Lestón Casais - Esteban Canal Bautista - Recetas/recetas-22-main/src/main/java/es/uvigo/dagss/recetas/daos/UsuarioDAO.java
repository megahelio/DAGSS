package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.Usuario;


public interface UsuarioDAO extends JpaRepository<Usuario, String> {

    List<Usuario> findByLoginContaining(String login);

}