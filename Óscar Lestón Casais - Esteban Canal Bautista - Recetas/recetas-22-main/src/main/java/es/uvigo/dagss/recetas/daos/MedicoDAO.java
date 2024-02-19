package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.CentroSalud;
import es.uvigo.dagss.recetas.entidades.Medico;

public interface MedicoDAO extends JpaRepository<Medico, String> {
    List<Medico> findByNombreContaining(String nombre);

    List<Medico> findByCentroSaludAsign(CentroSalud centroSaludAsign);

}