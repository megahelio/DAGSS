package es.uvigo.dagss.recetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
