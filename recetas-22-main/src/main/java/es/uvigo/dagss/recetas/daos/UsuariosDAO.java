package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.UsuarioEntidad;


public interface UsuariosDAO extends JpaRepository<UsuarioEntidad, String> {

    List<UsuarioEntidad> findByNombreContaining(String nombre);

    List<UsuarioEntidad> findByEmailContaining(String email);
}