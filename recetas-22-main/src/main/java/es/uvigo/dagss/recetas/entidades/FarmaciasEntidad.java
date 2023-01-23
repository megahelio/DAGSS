package es.uvigo.dagss.recetas.entidades;

import javax.persistence.*;

@Entity
public class FarmaciasEntidad extends UsuarioEntidad {

    public FarmaciasEntidad(String login, String nombreEstablecimiento, String nombreFarmaceutico,
            String apellidosFarmaceutico, String dni, String numColegiado, String telefono, String email, Estado estado,
            Direccion direccion) {
        super(login, nombreEstablecimiento, email);
        this.nombreFarmaceutico = nombreFarmaceutico;
        this.apellidosFarmaceutico = apellidosFarmaceutico;
        this.dni = dni;
        this.numColegiado = numColegiado;
        this.telefono = telefono;
        this.estado = estado;
        this.direccion = direccion;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String login;

    @Column(name = "nombreEstablecimiento")
    private String nombreEstablecimiento;

    @Column(name = "nombreFarmaceutico")
    private String nombreFarmaceutico;

    @Column(name = "apellidosFarmaceutico")
    private String apellidosFarmaceutico;

    @Column(name = "dni")
    private String dni;

    @Column(name = "numColegiado")
    private String numColegiado;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "Estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private Direccion direccion;

    public String getNombreEstablecimientop() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getNombreFarmaceutico() {
        return nombreFarmaceutico;
    }

    public void setNombreFarmaceutico(String nombreFarmaceutico) {
        this.nombreFarmaceutico = nombreFarmaceutico;
    }

    public String getApellidosFarmaceutico() {
        return apellidosFarmaceutico;
    }

    public void setApellidosFarmaceutico(String apellidosFarmaceutico) {
        this.apellidosFarmaceutico = apellidosFarmaceutico;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
