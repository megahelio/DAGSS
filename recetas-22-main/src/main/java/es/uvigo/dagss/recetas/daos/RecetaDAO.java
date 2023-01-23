package es.uvigo.dagss.recetas.daos;



import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.Receta;



public interface RecetaDAO extends JpaRepository<Receta, Long>{

}