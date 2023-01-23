package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import entidades.PacientesEntidad;


public interface PacientesDAO extends JpaRepository<PacientesEntidad, Long>{
    List<PacientesEntidad> findByNombreContaining(String nombre);
	List<PacientesEntidad> findByDireccionLocalidadContaining(String localidad);
    List<PacientesEntidad> findByDireccionProvinciaContaining(String provincia);

//Incompleto
}