package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.UsuarioEntidad;

public interface UsuariosDAO extends JpaRepository<UsuarioEntidad, String> {

    List<UsuarioEntidad> findByNombreContaining(String nombre);

    List<UsuarioEntidad> findByEmailContaining(String email);
}