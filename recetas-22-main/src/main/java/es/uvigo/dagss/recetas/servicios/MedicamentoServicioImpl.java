package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.dagss.recetas.daos.MedicamentoDAO;
import es.uvigo.dagss.recetas.entidades.Medicamento;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

@Service
public class MedicamentoServicioImpl implements GenericoServicio<Medicamento, Long> {

    @Autowired
    MedicamentoDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<Medicamento> buscarTodos() {
        return dao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Medicamento> buscarPorNombreComercial(String nombreComercial) {
        return dao.findByNombreComercial(nombreComercial);
    }

    @Transactional(readOnly = true)
    public List<Medicamento> buscarPorPrincipioActivo(String principioActivo) {
        return dao.findByNombreComercial(principioActivo);
    }
    
    @Transactional(readOnly = true)
    public List<Medicamento> buscarPorFabricante(String fabricante) {
        return dao.findByFabricante(fabricante);
    }

    @Transactional(readOnly = true)
    public List<Medicamento> buscarPorFamilia(String familia) {
        return dao.findByFabricante(familia);
    }

    
    @Override
    @Transactional(readOnly = true)
    public Optional<Medicamento> buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional
    public Medicamento modificar(Medicamento medicamentoentidad) {
        return dao.save(medicamentoentidad);
    }

    @Override
    @Transactional
    public Medicamento crear(Medicamento medicamentoentidad) {

        return dao.save(medicamentoentidad);
    }

}