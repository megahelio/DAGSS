package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.Cita;

public interface CitaServicio {

    List<Cita> buscarTodos();

    Optional<Cita> buscarPorId(Long id);

    void eliminar(Long id);

    Cita modificar(Cita usuarioentidad);

    Cita crear(Cita usuarioentidad);

}