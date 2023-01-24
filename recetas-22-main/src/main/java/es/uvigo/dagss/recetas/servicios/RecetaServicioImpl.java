package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import es.uvigo.dagss.recetas.entidades.Receta;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

public class RecetaServicioImpl implements GenericoServicio<Receta, Long> {

    @Override
    public List<Receta> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Receta> buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Receta modificar(Receta usuarioentidad) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Receta crear(Receta usuarioentidad) {
        // TODO Auto-generated method stub
        return null;
    }

}