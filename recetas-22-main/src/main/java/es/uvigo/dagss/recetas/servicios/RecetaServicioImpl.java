package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.dagss.recetas.daos.RecetaDAO;
import es.uvigo.dagss.recetas.entidades.Prescripcion;
import es.uvigo.dagss.recetas.entidades.Receta;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

@Service
public class RecetaServicioImpl implements GenericoServicio<Receta, Long> {

    @Autowired
    RecetaDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<Receta> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Receta> buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional
    public Receta modificar(Receta recetaentidad) {
        return dao.save(recetaentidad);
    }

    @Override
    @Transactional
    public Receta crear(Receta recetaentidad) {

        return dao.save(recetaentidad);
    }

    public List<Receta> findByPrenscripcionRecetaContaining(Prescripcion prenscripcionReceta) {
        return dao.findByPrenscripcionReceta(prenscripcionReceta);
    }

}