package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.MedicosEntidad;


public interface MedicosDAO extends JpaRepository<MedicosEntidad, String>{
    List<MedicosEntidad> findByNombreContaining(String nombre);
	List<MedicosEntidad> findByDireccionLocalidadContaining(String localidad);
    List<MedicosEntidad> findByDireccionProvinciaContaining(String provincia);
    //Incompleto

}