package daos;

import org.springframework.data.jpa.repository.JpaRepository;
import entidades.CentroSaludEntidad;


public interface UsuariosDAO extends JpaRepository<CentroSaludEntidad, Long>{
}