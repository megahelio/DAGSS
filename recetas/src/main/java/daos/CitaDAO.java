package daos;

import org.springframework.data.jpa.repository.JpaRepository;
import entidades.CitasEntidad;


public interface CitaDAO extends JpaRepository<CitasEntidad, Long>{


}