package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.uvigo.dagss.recetas.daos.AdministradorDAO;
import es.uvigo.dagss.recetas.entidades.Administrador;
import es.uvigo.dagss.recetas.servicios.Genericos.GenericoServicio;

public class AdministradorServicioImpl implements GenericoServicio<Administrador, String> {
    @Autowired
    AdministradorDAO dao;

    @Override
    public List<Administrador> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public Optional<Administrador> buscarPorId(String login) {
        return dao.findById(login);
    }

    @Override
    public void eliminar(String login) {
        dao.deleteById(login);

    }

    @Override
    public Administrador modificar(Administrador usuarioentidad) {
        return dao.save(usuarioentidad);
    }

    @Override
    public Administrador crear(Administrador usuarioentidad) {
        return dao.save(usuarioentidad);
    }

}