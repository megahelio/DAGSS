package entidades;
import javax.persistence.*;

@Entity
@Table(name = "medicamentos")
public class MedicamentosEntidad{

    public MedicamentosEntidad(String nombreComercial, String principioActivo, String fabricante, String familia, int numDosis, Estado estado) {
        this.nombreComercial = nombreComercial;
        this.principioActivo = principioActivo;
        this.fabricante = fabricante;
        this.familia = familia;
        this.numDosis = numDosis;
        this.estado = estado;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreComercial")
    private String nombreComercial;

    @Column(name = "principioActivo")
    private String principioActivo;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "familia")
    private String familia;

    @Column(name = "numDosis")
    private int numDosis;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public int getNumDosis() {
        return numDosis;
    }

    public void setNumDosis(int numDosis) {
        this.numDosis = numDosis;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}


