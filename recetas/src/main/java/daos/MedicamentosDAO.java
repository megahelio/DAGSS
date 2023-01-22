package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import entidades.CentroSaludEntidad;
import entidades.MedicamentosEntidad;


public interface MedicamentosDAO extends JpaRepository<MedicamentosEntidad, Long>{
    List<MedicamentosEntidad> findByNombreComercial(String nombreComercial);
	List<MedicamentosEntidad> findByPrincipioActivo(String principioActivo);
    List<MedicamentosEntidad> findByFabricante(String fabricante);
    List<MedicamentosEntidad> findByFamilia(String familia);
}