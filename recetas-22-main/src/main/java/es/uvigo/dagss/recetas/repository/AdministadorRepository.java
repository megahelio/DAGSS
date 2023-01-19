package es.uvigo.dagss.recetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.Administrador;


public interface AdministadorRepository extends JpaRepository<Administrador, Integer> {
    
}
