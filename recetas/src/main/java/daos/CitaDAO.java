package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import entidades.CitasEntidad;


public interface CitaDAO extends JpaRepository<CitasEntidad, Long>{


}