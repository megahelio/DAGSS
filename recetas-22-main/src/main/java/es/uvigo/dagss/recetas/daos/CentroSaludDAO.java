package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uvigo.dagss.recetas.entidades.CentroSaludEntidad;


public interface CentroSaludDAO extends JpaRepository<CentroSaludEntidad, Long>{
    List<CentroSaludEntidad> findByNombreContaining(String nombre);
	List<CentroSaludEntidad> findByDireccionLocalidadContaining(String localidad);
    List<CentroSaludEntidad> findByDireccionProvinciaContaining(String provincia);
}