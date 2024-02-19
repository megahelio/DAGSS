package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.dagss.recetas.daos.PrescripcionDAO;
import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.entidades.Prescripcion;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

@Service
public class PrescripcionServicioImpl implements GenericoServicio<Prescripcion, Long> {

    @Autowired
    PrescripcionDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<Prescripcion> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Prescripcion> buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional
    public Prescripcion modificar(Prescripcion prescripcionentidad) {
        return dao.save(prescripcionentidad);
    }

    @Override
    @Transactional
    public Prescripcion crear(Prescripcion prescripcionentidad) {

        return dao.save(prescripcionentidad);
    }

    public List<Prescripcion> buscarPorPacienteContaining(Paciente paciente) {
        return dao.findByPaciente(paciente);
    }

}