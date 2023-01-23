package es.uvigo.dagss.recetas.daos;



import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.RecetasEntidad;



public interface RecetasDAO extends JpaRepository<RecetasEntidad, Long>{

}