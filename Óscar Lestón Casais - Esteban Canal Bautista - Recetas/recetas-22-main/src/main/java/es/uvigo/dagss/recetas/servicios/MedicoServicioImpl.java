package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.dagss.recetas.daos.MedicoDAO;
import es.uvigo.dagss.recetas.entidades.CentroSalud;
import es.uvigo.dagss.recetas.entidades.Medico;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

@Service
public class MedicoServicioImpl implements GenericoServicio<Medico, String> {
    @Autowired
    MedicoDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<Medico> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Medico> buscarPorId(String id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Medico> buscarPorNombreContaining(String nombre) {
        return dao.findByNombreContaining(nombre);
    }

    @Transactional(readOnly = true)
    public List<Medico> buscarPorCentroSaludAsignContaining(CentroSalud centroSaludAsign) {
        return dao.findByCentroSaludAsign(centroSaludAsign);
    }

    @Override
    @Transactional
    public void eliminar(String id) {
        dao.deleteById(id);

    }

    @Override
    @Transactional
    public Medico modificar(Medico usuarioentidad) {
        return dao.save(usuarioentidad);
    }

    @Override
    @Transactional
    public Medico crear(Medico usuarioentidad) {
        return dao.save(usuarioentidad);
    }

}