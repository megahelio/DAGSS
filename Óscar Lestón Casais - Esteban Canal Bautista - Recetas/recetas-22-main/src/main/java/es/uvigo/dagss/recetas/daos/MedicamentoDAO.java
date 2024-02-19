package es.uvigo.dagss.recetas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.uvigo.dagss.recetas.entidades.Medicamento;


public interface MedicamentoDAO extends JpaRepository<Medicamento, Long>{
    List<Medicamento> findByNombreComercial(String nombreComercial);
	List<Medicamento> findByPrincipioActivo(String principioActivo);
    List<Medicamento> findByFabricante(String fabricante);
    List<Medicamento> findByFamilia(String familia);
}