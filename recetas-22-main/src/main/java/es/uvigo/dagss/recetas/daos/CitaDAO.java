package es.uvigo.dagss.recetas.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uvigo.dagss.recetas.entidades.CitasEntidad;


public interface CitaDAO extends JpaRepository<CitasEntidad, Long>{


}