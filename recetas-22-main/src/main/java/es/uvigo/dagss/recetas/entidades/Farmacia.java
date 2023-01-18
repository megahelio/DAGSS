package es.uvigo.dagss.recetas.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FARMACIA")
public class Farmacia extends Usuario {

    // Anadir atributos propios
	
    public Farmacia() {
        super(TipoUsuario.FARMACIA);
    }
    
}
