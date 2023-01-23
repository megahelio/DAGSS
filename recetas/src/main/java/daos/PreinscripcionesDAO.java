package daos;

import org.springframework.data.jpa.repository.JpaRepository;
import entidades.PreinscripcionEntidad;


public interface PreinscripcionesDAO extends JpaRepository<PreinscripcionEntidad, Long>{

}