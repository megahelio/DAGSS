package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import entidades.AdministradorEntidad;

public interface AdministradorDAO extends JpaRepository<AdministradorEntidad, Long>{

}

