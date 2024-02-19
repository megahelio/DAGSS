package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.dagss.recetas.daos.CitaDAO;
import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

@Service
public class CitaServicioImpl implements GenericoServicio<Cita, Long> {

    @Autowired
    CitaDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cita> buscarPorId(Long id) {
        return dao.findById(id);
    }


    @Transactional(readOnly = true)
    public List<Cita> buscarPorPaciente(Paciente paciente) {
        return dao.findByPacienteCitado(paciente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        dao.deleteById(id);

    }

    @Override
    @Transactional
    public Cita modificar(Cita entidad) {
        return dao.save(entidad);
    }

    @Override
    @Transactional
    public Cita crear(Cita entidad) {
        return dao.save(entidad);
    }

}
