package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uvigo.dagss.recetas.entidades.CentroSalud;


public interface CentroSaludDAO extends JpaRepository<CentroSalud, Long>{
    List<CentroSalud> findByNombreContaining(String nombre);
	List<CentroSalud> findByDireccionLocalidadContaining(String localidad);
    List<CentroSalud> findByDireccionProvinciaContaining(String provincia);
}