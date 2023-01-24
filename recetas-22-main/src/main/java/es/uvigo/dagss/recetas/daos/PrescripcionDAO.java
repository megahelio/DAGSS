package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.entidades.Prescripcion;

public interface PrescripcionDAO extends JpaRepository<Prescripcion, Long> {

    List<Prescripcion> findByPaciente(Paciente paciente);

}