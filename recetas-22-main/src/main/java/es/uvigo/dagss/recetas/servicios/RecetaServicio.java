package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.Receta;

public interface RecetaServicio {

    List<Receta> buscarTodos();

    Optional<Receta> buscarPorId(Long id);

    void eliminar(Long id);

    Receta modificar(Receta usuarioentidad);

    Receta crear(Receta usuarioentidad);

}