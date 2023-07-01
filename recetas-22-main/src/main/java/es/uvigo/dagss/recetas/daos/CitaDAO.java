package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Paciente;


public interface CitaDAO extends JpaRepository<Cita, Long>{

    List<Cita> findByPacienteCitado(Paciente paciente);
}