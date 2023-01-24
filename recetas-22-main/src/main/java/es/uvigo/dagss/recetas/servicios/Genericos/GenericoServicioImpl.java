package es.uvigo.dagss.recetas.servicios.Genericos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericoServicioImpl<T, K> implements GenericoServicio<T, K> {

    @Autowired
    JpaRepository<T, K> dao;


    @Override
    @Transactional(readOnly = true)
    public Optional<T> buscarPorId(K id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> buscarTodos() {
        return dao.findAll();
    }

    @Override
    @Transactional
    public T crear(T usuarioentidad) {
        return dao.save(usuarioentidad);
    }

    @Override
    @Transactional
    public void eliminar(K id) {
        dao.deleteById(id);
        ;

    }

    // esto es redundante porque dao.save edita la entidad de la base de datos si
    // esta existe y si no existe entonces la crea
    @Override
    @Transactional
    public T modificar(T usuarioentidad) {
        return dao.save(usuarioentidad);
    }

}
