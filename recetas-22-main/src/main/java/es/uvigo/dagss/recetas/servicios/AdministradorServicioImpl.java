package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.dagss.recetas.daos.AdministradorDAO;
import es.uvigo.dagss.recetas.entidades.Administrador;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

@Service
public class AdministradorServicioImpl implements GenericoServicio<Administrador, String> {

    @Autowired
    AdministradorDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<Administrador> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Administrador> buscarPorId(String login) {
        return dao.findById(login);
    }

    @Override
    public void eliminar(String login) {
        dao.deleteById(login);
    }

    @Override
    @Transactional
    public Administrador modificar(Administrador administradorentidad) {
        return dao.save(administradorentidad);
    }

    @Override
    @Transactional
    public Administrador crear(Administrador administradorentidad) {

        return dao.save(administradorentidad);
    }

}