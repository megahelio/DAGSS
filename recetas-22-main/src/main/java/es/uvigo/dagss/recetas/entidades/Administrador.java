package es.uvigo.dagss.recetas.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ADMINISTRADOR")
public class Administrador extends Usuario {

    // Anadir atributos propios
	
    public Administrador() {
        super(TipoUsuario.ADMINISTRADOR); 
    }



}
