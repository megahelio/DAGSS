package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.Medicamento;

public interface MedicamentoServicio {

    List<Medicamento> buscarTodos();

    Optional<Medicamento> buscarPorId(Long id);

    void eliminar(Long id);

    Medicamento modificar(Medicamento usuarioentidad);

    Medicamento crear(Medicamento usuarioentidad);

}