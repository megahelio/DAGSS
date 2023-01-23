package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.Farmacia;


public interface FarmaciaDAO extends JpaRepository<Farmacia, String>{
    List<Farmacia> findByNombreEstablecimientoContaining(String nombreEstablecimiento);
	List<Farmacia> findByDireccionLocalidadContaining(String localidad);
    List<Farmacia> findByDireccionProvinciaContaining(String provincia);
}
