package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.uvigo.dagss.recetas.daos.CentroSaludDAO;
import es.uvigo.dagss.recetas.entidades.CentroSalud;

public class CentroSaludServicioImpl implements CentroSaludServicio {
    @Autowired
    CentroSaludDAO dao;

    @Override
    public List<CentroSalud> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<CentroSalud> buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public CentroSalud modificar(CentroSalud usuarioentidad) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CentroSalud crear(CentroSalud usuarioentidad) {
        // TODO Auto-generated method stub
        return null;
    }

}