package es.uvigo.dagss.recetas.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uvigo.dagss.recetas.daos.UsuarioDAO;
import es.uvigo.dagss.recetas.entidades.Usuario;



@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    @Autowired
    UsuarioDAO dao;


    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> buscarPorLogin(String login) {
        return dao.findById(login);
    }

    @Override
    public void eliminar(Usuario usuarioEntidad) {
        dao.delete(usuarioEntidad);
    }

    @Override
    @Transactional
    public Usuario modificar(Usuario usuarioentidad) {
        return dao.save(usuarioentidad);
    }

    @Override
    @Transactional
    public Usuario crear(Usuario usuarioentidad) {

        return dao.save(usuarioentidad);
    }

}