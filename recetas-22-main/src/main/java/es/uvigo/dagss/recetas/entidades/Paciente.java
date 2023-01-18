package es.uvigo.dagss.recetas.entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PACIENTE")
public class Paciente extends Usuario {

	// Anadir atributos propios
   

    public Paciente() {
        super(TipoUsuario.PACIENTE);        
    }

}
