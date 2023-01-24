package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.dagss.recetas.daos.PacienteDAO;
import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

@Service
public class PacienteServicioImpl implements GenericoServicio<Paciente, String> {
    @Autowired
    PacienteDAO dao;

    @Override
    @Transactional
    public List<Paciente> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public Optional<Paciente> buscarPorId(String id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Paciente> buscarPorNombreContaining(String nombre) {
        return dao.findByNombreContaining(nombre);
    }

    @Transactional(readOnly = true)
    public List<Paciente> buscarPorDireccionLocalidadContaining(String localidad) {
        return dao.findByDireccionLocalidadContaining(localidad);
    }

    @Transactional(readOnly = true)
    public List<Paciente> buscarByDireccionProvinciaContaining(String provincia) {
        return dao.findByDireccionLocalidadContaining(provincia);
    }

    @Override
    @Transactional
    public void eliminar(String id) {
        dao.deleteById(id);

    }

    @Override
    @Transactional
    public Paciente modificar(Paciente usuarioentidad) {
        return dao.save(usuarioentidad);
    }

    @Override
    @Transactional
    public Paciente crear(Paciente usuarioentidad) {
        return dao.save(usuarioentidad);
    }

}