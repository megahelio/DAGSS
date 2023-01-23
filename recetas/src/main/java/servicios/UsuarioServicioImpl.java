package servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.UsuariosDAO;
import entidades.UsuarioEntidad;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    @Autowired
    UsuariosDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioEntidad> buscarPorEmail(String email) {
        return dao.findByEmailContaining(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioEntidad> buscarPorNombre(String nombre) {
        return dao.findByNombreContaining(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioEntidad> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioEntidad> buscarPorLogin(String login) {
        return dao.findById(login);
    }

    @Override
    public void eliminar(UsuarioEntidad usuarioEntidad) {
        dao.delete(usuarioEntidad);
    }

    @Override
    @Transactional
    public UsuarioEntidad modificar(UsuarioEntidad usuarioentidad) {
        return dao.save(usuarioentidad);
    }

    @Override
    @Transactional
    public UsuarioEntidad crear(UsuarioEntidad usuarioentidad) {

        return dao.save(usuarioentidad);
    }

}
