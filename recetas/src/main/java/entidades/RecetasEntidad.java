package entidades;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "recetas")
public class RecetasEntidad {

    /// CREO QUE ESTA MAL PORQUE TIENE QUE HEREDAR DE MEDICAMENTO CREO

    public RecetasEntidad(String prenscripcionReceta, LocalDateTime fechaInicioValidez, LocalDateTime fechaFinValidez,
            int numUnidades, Receta receta) {
        this.prenscripcionReceta = prenscripcionReceta;
        this.fechaInicioValidez = fechaInicioValidez;
        this.fechaFinValidez = fechaFinValidez;
        this.numUnidades = numUnidades;
        this.receta = Receta.PLANIFICADA;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prenscripcionReceta")
    private String prenscripcionReceta;

    @Column(name = "fechaInicioValidez")
    private LocalDateTime fechaInicioValidez;

    @Column(name = "fechaFinValidez")
    private LocalDateTime fechaFinValidez;

    @Column(name = "numUnidades")
    private int numUnidades;

    @Column(name = "Receta")
    @Enumerated(EnumType.STRING)
    private Receta receta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenscripcionReceta() {
        return prenscripcionReceta;
    }

    public void setPrenscripcionReceta(String prenscripcionReceta) {
        this.prenscripcionReceta = prenscripcionReceta;
    }

    public int getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(int numUnidades) {
        this.numUnidades = numUnidades;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }
}
