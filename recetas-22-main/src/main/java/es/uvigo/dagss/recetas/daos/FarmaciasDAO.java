package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.FarmaciasEntidad;


public interface FarmaciasDAO extends JpaRepository<FarmaciasEntidad, String>{
    List<FarmaciasEntidad> findByNombreContaining(String nombre);
	List<FarmaciasEntidad> findByDireccionLocalidadContaining(String localidad);
    List<FarmaciasEntidad> findByDireccionProvinciaContaining(String provincia);
}
