package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uvigo.dagss.recetas.entidades.Paciente;


public interface PacienteDAO extends JpaRepository<Paciente, String>{
    List<Paciente> findByNombreContaining(String nombre);
	List<Paciente> findByDireccionLocalidadContaining(String localidad);
    List<Paciente> findByDireccionProvinciaContaining(String provincia);

//Incompleto
}