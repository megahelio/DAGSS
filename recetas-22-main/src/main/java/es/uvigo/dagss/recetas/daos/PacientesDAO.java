package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uvigo.dagss.recetas.entidades.PacientesEntidad;


public interface PacientesDAO extends JpaRepository<PacientesEntidad, String>{
    List<PacientesEntidad> findByNombreContaining(String nombre);
	List<PacientesEntidad> findByDireccionLocalidadContaining(String localidad);
    List<PacientesEntidad> findByDireccionProvinciaContaining(String provincia);

//Incompleto
}