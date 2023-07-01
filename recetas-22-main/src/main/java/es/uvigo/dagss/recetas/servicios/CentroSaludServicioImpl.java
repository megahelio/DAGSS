package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uvigo.dagss.recetas.daos.CentroSaludDAO;
import es.uvigo.dagss.recetas.entidades.CentroSalud;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

@Service
public class CentroSaludServicioImpl implements GenericoServicio<CentroSalud, Long> {
    @Autowired
    CentroSaludDAO dao;

    @Override
    public List<CentroSalud> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public Optional<CentroSalud> buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        dao.deleteById(id);;

    }

    @Override
    public CentroSalud modificar(CentroSalud usuarioentidad) {
        return dao.save(usuarioentidad);
    }

    @Override
    public CentroSalud crear(CentroSalud usuarioentidad) {
        return dao.save(usuarioentidad);
    }

}