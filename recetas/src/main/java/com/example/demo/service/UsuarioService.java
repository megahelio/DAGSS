package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository UsuarioRepository;

    public List<Usuario> listAllUsuario() {
        return UsuarioRepository.findAll();
    }

    public void saveUsuario(Usuario Usuario) {
        UsuarioRepository.save(Usuario);
    }

    public Usuario getUsuario(Integer id) {
        return UsuarioRepository.findById(id).get();
    }

    public void deleteUsuario(Integer id) {
        UsuarioRepository.deleteById(id);
    }

    /**
     * Devuelve el usuario que se logea o null
     * @param login
     * @param password
     * @return
     */
    public Usuario findByLoginAndPassword(String login, String password) {
        return null;
    }
}
