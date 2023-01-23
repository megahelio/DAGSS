package es.uvigo.dagss.recetas.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.entidades.AdministradorEntidad;

public interface AdministradorDAO extends JpaRepository<AdministradorEntidad, String>{

}

