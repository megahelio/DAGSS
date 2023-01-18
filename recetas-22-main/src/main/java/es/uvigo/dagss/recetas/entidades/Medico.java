package es.uvigo.dagss.recetas.entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Usuario {

    // Anadir atributos propios
    
    public Medico() {
        super(TipoUsuario.MEDICO);
    }


}
