package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.dagss.recetas.daos.FarmaciaDAO;
import es.uvigo.dagss.recetas.entidades.Farmacia;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

@Service
public class FarmaciaServicioImpl implements GenericoServicio<Farmacia, String> {

    @Autowired
    FarmaciaDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<Farmacia> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Farmacia> buscarPorId(String id) {
        return dao.findById(id);
    }

        
    @Transactional(readOnly = true)
    public List<Farmacia> BuscarPorNombreEstablecimientoContaining(String nombreEstablecimiento) {
        return dao.findByNombreEstablecimientoContaining(nombreEstablecimiento);
    }

    @Transactional(readOnly = true)
    public List<Farmacia> BuscarPorDireccionLocalidadContaining(String localidad) {
        return dao.findByDireccionLocalidadContaining(localidad);
    }

    @Transactional(readOnly = true)
    public List<Farmacia> BuscarPorDireccionProvinciaContaining(String provincia) {
        return dao.findByDireccionProvinciaContaining(provincia);
}

    @Override
    @Transactional
    public void eliminar(String id) {
        dao.deleteById(id);

    }

    @Override
    @Transactional
    public Farmacia modificar(Farmacia entidad) {
        return dao.save(entidad);
    }

    @Override
    @Transactional
    public Farmacia crear(Farmacia entidad) {
        return dao.save(entidad);
    }

}
