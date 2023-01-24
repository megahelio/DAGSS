package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.Prescripcion;

public interface PrescripcionServicio {

    List<Prescripcion> buscarTodos();

    Optional<Prescripcion> buscarPorId(Long id);

    void eliminar(Long id);

    Prescripcion modificar(Prescripcion usuarioentidad);

    Prescripcion crear(Prescripcion usuarioentidad);

}