package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entidades.MedicosEntidad;


public interface MedicosDAO extends JpaRepository<MedicosEntidad, Long>{
    List<MedicosEntidad> findByNombreContaining(String nombre);
	List<MedicosEntidad> findByDireccionLocalidadContaining(String localidad);
    List<MedicosEntidad> findByDireccionProvinciaContaining(String provincia);
    //Incompleto

}