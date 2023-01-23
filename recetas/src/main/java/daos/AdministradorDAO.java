package daos;

import org.springframework.data.jpa.repository.JpaRepository;


import entidades.AdministradorEntidad;

public interface AdministradorDAO extends JpaRepository<AdministradorEntidad, Long>{

}

