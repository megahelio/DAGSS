package es.uvigo.dagss.recetas.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uvigo.dagss.recetas.entidades.PreinscripcionEntidad;


public interface PreinscripcionesDAO extends JpaRepository<PreinscripcionEntidad, Long>{

}