package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.FarmaciasEntidad;


public interface FarmaciasDAO extends JpaRepository<FarmaciasEntidad, Long>{
    List<FarmaciasEntidad> findByNombreContaining(String nombre);
	List<FarmaciasEntidad> findByDireccionLocalidadContaining(String localidad);
    List<FarmaciasEntidad> findByDireccionProvinciaContaining(String provincia);
}
