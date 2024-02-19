package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.Prescripcion;
import es.uvigo.dagss.recetas.entidades.Receta;

public interface RecetaDAO extends JpaRepository<Receta, Long> {

    List<Receta> findByPrenscripcionReceta(Prescripcion prenscripcionReceta);
}