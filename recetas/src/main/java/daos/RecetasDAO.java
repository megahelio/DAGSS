package daos;



import org.springframework.data.jpa.repository.JpaRepository;

import entidades.RecetasEntidad;


public interface RecetasDAO extends JpaRepository<RecetasEntidad, Long>{

}