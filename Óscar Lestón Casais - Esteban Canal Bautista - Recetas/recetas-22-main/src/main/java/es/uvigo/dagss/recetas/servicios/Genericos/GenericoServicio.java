package es.uvigo.dagss.recetas.servicios.Genericos;

import java.util.List;
import java.util.Optional;

/**
 * GenericoServicio<T,K>
 * 
 * @param T --> Entidad (Medico, Paciente, CentroMedico, Receta, ...)
 * 
 * @param K --> Tipo de la clave (String, Long, ...)
 * 
 */
public interface GenericoServicio<T,K> {
    List<T> buscarTodos();

    Optional<T> buscarPorId(K id);

    void eliminar(K id);

    T modificar(T entidad);

    T crear(T entidad);
}
