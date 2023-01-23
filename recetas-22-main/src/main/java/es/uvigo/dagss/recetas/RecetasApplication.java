package es.uvigo.dagss.recetas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.uvigo.dagss.recetas.daos.AdministradorDAO;
import es.uvigo.dagss.recetas.daos.CitaDAO;
import es.uvigo.dagss.recetas.daos.FarmaciaDAO;
import es.uvigo.dagss.recetas.daos.MedicamentoDAO;
import es.uvigo.dagss.recetas.daos.MedicoDAO;
import es.uvigo.dagss.recetas.daos.PacienteDAO;
import es.uvigo.dagss.recetas.daos.PrescripcionDAO;
import es.uvigo.dagss.recetas.daos.RecetaDAO;
import es.uvigo.dagss.recetas.daos.UsuarioDAO;
import es.uvigo.dagss.recetas.entidades.CentroSalud;
import es.uvigo.dagss.recetas.entidades.Direccion;

@SpringBootApplication

public class RecetasApplication implements CommandLineRunner {
    @Autowired
    AdministradorDAO administradorDAO;
    @Autowired
    CentroSalud centroSalud;
    @Autowired
    CitaDAO citaDAO;
    @Autowired
    FarmaciaDAO FarmaciaDAO;
    @Autowired
    MedicamentoDAO medicamentoDAO;
    @Autowired
    MedicoDAO medicoDAO;
    @Autowired
    PacienteDAO pacienteDAO;
    @Autowired
    PrescripcionDAO prescripcionDAO;
    @Autowired
    RecetaDAO recetaDAO;
    @Autowired
    UsuarioDAO usuarioDAO;

    public static void main(String[] args) {
        SpringApplication.run(RecetasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        crearCosas();
        recuperarCosas();

    }

    private void crearCosas() {

        Direccion d1 = new Direccion("calle 1", "Localidad 1", "11111", "Ourense");
        Direccion d2 = new Direccion("calle 2", "Localidad 2", "22222", "A Coruña");
        Direccion d3 = new Direccion("calle 3", "Localidad 3", "33333", "A Coruña");

    }

    private void recuperarCosas() {
    }

}