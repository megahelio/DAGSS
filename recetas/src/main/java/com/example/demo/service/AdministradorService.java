package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Administrador;
import com.example.demo.repository.AdministadorRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdministradorService {
    @Autowired
    private AdministadorRepository administradorRepository;

    public List<Administrador> listAllAdministrador() {
        return administradorRepository.findAll();
    }

    public void saveAdministrador(Administrador administrador) {
        administradorRepository.save(administrador);
    }

    public Administrador getAdministrador(Integer id) {
        return administradorRepository.findById(id).get();
    }

    public void deleteAdministrador(Integer id) {
        administradorRepository.deleteById(id);
    }
}