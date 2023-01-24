package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.CentroSalud;

public interface CentroSaludServicio {

    List<CentroSalud> buscarTodos();

    Optional<CentroSalud> buscarPorId(Long id);

    void eliminar(Long id);

    CentroSalud modificar(CentroSalud usuarioentidad);

    CentroSalud crear(CentroSalud usuarioentidad);

}