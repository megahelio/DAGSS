package es.uvigo.dagss.recetas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import es.uvigo.dagss.recetas.daos.AdministradorDAO;
import es.uvigo.dagss.recetas.daos.CentroSaludDAO;
import es.uvigo.dagss.recetas.daos.CitaDAO;
import es.uvigo.dagss.recetas.daos.FarmaciaDAO;
import es.uvigo.dagss.recetas.daos.MedicamentoDAO;
import es.uvigo.dagss.recetas.daos.MedicoDAO;
import es.uvigo.dagss.recetas.daos.PacienteDAO;
import es.uvigo.dagss.recetas.daos.PrescripcionDAO;
import es.uvigo.dagss.recetas.daos.RecetaDAO;
import es.uvigo.dagss.recetas.daos.UsuarioDAO;
import es.uvigo.dagss.recetas.entidades.Administrador;
import es.uvigo.dagss.recetas.entidades.CentroSalud;
import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Direccion;
import es.uvigo.dagss.recetas.entidades.Farmacia;
import es.uvigo.dagss.recetas.entidades.Medicamento;
import es.uvigo.dagss.recetas.entidades.Medico;
import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.entidades.Prescripcion;
import es.uvigo.dagss.recetas.entidades.Receta;
import es.uvigo.dagss.recetas.entidades.Rol;

@SpringBootApplication

public class RecetasApplication implements CommandLineRunner {
        @Autowired
        AdministradorDAO administradorDAO;
        @Autowired
        CentroSaludDAO centroSaludDAO;
        @Autowired
        CitaDAO citaDAO;
        @Autowired
        FarmaciaDAO farmaciaDAO;
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

                List<Administrador> administradorList = new ArrayList<>();
                administradorList.add(new Administrador("pepeadmin", "pepeadmin", "pepe", "pepe@correo.com"));
                administradorList.add(new Administrador("anaadmin", "anaadmin", "ana", "ana@correo.com"));
                administradorDAO.saveAll(administradorList);

                List<CentroSalud> centroSaludList = new ArrayList<>();
                CentroSalud centroSalud1 = new CentroSalud("Clinica del Este", "555-111-2222", "este@clinica.com", d1);
                CentroSalud centroSalud2 = new CentroSalud("Hospital Central", "555-555-5555", "central@hospital.com",
                                d2);
                centroSaludList.add(centroSalud1);
                centroSaludList.add(centroSalud2);
                centroSaludDAO.saveAll(centroSaludList);

                Medico medico0 = new Medico("jdoe", "password123", "John", "Doe", "12345678A", "12345", "555-555-5555",
                                "johndoe@email.com", centroSalud1);
                Medico medico1 = new Medico("jdoe", "password123", "John", "Doe", "12345678A", "12345", "555-555-5555",
                                "johndoe@email.com", centroSalud1);
                Medico medico2 = new Medico("jsmith", "password456", "Jane", "Smith", "87654321B", "67890",
                                "555-444-3333",
                                "janesmith@email.com", centroSalud1);
                Medico medico3 = new Medico("mjones", "password789", "Michael", "Jones", "13572468C", "24680",
                                "555-222-1111",
                                "michaeljones@email.com", centroSalud1);
                Medico medico4 = new Medico("rwilliams", "password101", "Robert", "Williams", "24681357D", "13579",
                                "555-111-2222", "robertwilliams@email.com", centroSalud1);
                Medico medico5 = new Medico("jbrown", "password112", "Jack", "Brown", "36925814E", "25814",
                                "555-555-5555",
                                "jackbrown@email.com", centroSalud2);
                Medico medico6 = new Medico("dmillar", "password113", "David", "Miller", "48152637F", "15263",
                                "555-444-3333",
                                "davidmiller@email.com", centroSalud2);
                Medico medico7 = new Medico("kgreen", "password114", "Kevin", "Green", "63748152G", "74815",
                                "555-222-1111",
                                "kevingreen@email.com", centroSalud2);
                Medico medico8 = new Medico("jdavis", "password115", "James", "Davis", "81522468H", "52246",
                                "555-111-2222",
                                "jamesdavis@email.com", centroSalud2);
                medicoDAO.save(medico0);
                medicoDAO.save(medico1);
                medicoDAO.save(medico2);
                medicoDAO.save(medico3);
                medicoDAO.save(medico4);
                medicoDAO.save(medico5);
                medicoDAO.save(medico6);
                medicoDAO.save(medico7);
                medicoDAO.save(medico8);

                try {
                        Paciente p1 = new Paciente("johndoe", "password123", "John", "Doe", "12345678A", "1111111111",
                                        "2222222222",
                                        "555-555-5555", "johndoe@example.com",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970"), medico0, d1);
                        // comparten direccion
                        // porque son una
                        // comuna hippie, esta
                        // gente empezó
                        // internet y claro
                        // luego viene
                        // vladimir y podrían
                        // pasar cosas.
                        Paciente p2 = new Paciente("janedoe", "password456", "Jane", "Doe", "87654321B", "2222222222",
                                        "3333333333",
                                        "555-555-5555", "janedoe@example.com",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("03/04/1995"), medico0, d3);
                        Paciente p3 = new Paciente("michaelj", "password789", "Michael", "Johnson", "13572468C",
                                        "3333333333",
                                        "4444444444",
                                        "555-555-5555", "michaelj@example.com",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("03/03/1990"), medico1, d3);
                        Paciente p4 = new Paciente("sarahm", "password101", "Sarah", "Miller", "24680753D",
                                        "4444444444",
                                        "5555555555",
                                        "555-555-5555", "sarahm@example.com",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("04/04/2000"), medico1, d2);
                        Paciente p5 = new Paciente("davids", "password112", "David", "Smith", "35798642E", "5555555555",
                                        "6666666666",
                                        "555-555-5555", "davids@example.com",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2010"), medico1, d2);
                        Paciente p6 = new Paciente("jenniferg", "password121", "Jennifer", "Garcia", "46820537F",
                                        "6666666666",
                                        "7777777777",
                                        "555-555-5555", "jenniferg@example.com",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("06/06/1995"), medico2, d1);
                        Paciente p7 = new Paciente("richardh", "password211", "Richard", "Harris", "57938642G",
                                        "7777777777",
                                        "8888888888",
                                        "555-555-5555", "richardh@example.com",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("07/07/1985"), medico3, d2);
                        Paciente p8 = new Paciente("charlesj", "password311", "Charles", "Johnson", "68507239H",
                                        "8888888888",
                                        "9999999999",
                                        "555-555-5555", "charlesj@example.com",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("08/08/1975"), medico4, d2);
                        pacienteDAO.save(p1);
                        pacienteDAO.save(p2);
                        pacienteDAO.save(p3);
                        pacienteDAO.save(p4);
                        pacienteDAO.save(p5);
                        pacienteDAO.save(p6);
                        pacienteDAO.save(p7);
                        pacienteDAO.save(p8);

                        Cita c1 = new Cita(p1, medico1, new SimpleDateFormat("dd/MM/yyyy").parse("07/07/2023"), 30);
                        citaDAO.save(c1);
                        Cita c2 = new Cita(p2, medico0,
                                        new SimpleDateFormat("dd/MM/yyyy").parse("08/07/2023"), 45);
                        citaDAO.save(c2);
                        Cita cita = new Cita(p2, medico0,
                                        new SimpleDateFormat("dd/MM/yyyy").parse("02/03/2023"), 60);
                        citaDAO.save(cita);
                        Cita cita2 = new Cita(p7, medico4,
                                        new SimpleDateFormat("dd/MM/yyyy").parse("07/03/2023"), 30);
                        citaDAO.save(cita2);
                        Cita cita3 = new Cita(p4, medico5,
                                        new SimpleDateFormat("dd/MM/yyyy").parse("05/04/2023"), 60);
                        citaDAO.save(cita3);

                        Farmacia farmacia = new Farmacia("farmacia1", "password123", Rol.FARMACIA, "12345678A",
                                        "Farmacia Central",
                                        "Juan", "Perez",
                                        "123456", "555-555-5555", "farmacia1@example.com",
                                        new Direccion("C/Main St", "Anytown", "12345", "USA"));
                        farmaciaDAO.save(farmacia);
                        Farmacia farmacia2 = new Farmacia("farmacia2", "password456", Rol.FARMACIA, "87654321B",
                                        "Farmacia del Barrio", "Maria",
                                        "Garcia", "234567", "555-555-5555", "farmacia2@example.com",
                                        new Direccion("C/ Park Ave", "Anycity", "54321", "USA"));
                        farmaciaDAO.save(farmacia2);
                        Farmacia farmacia3 = new Farmacia("farmacia3", "password789", Rol.FARMACIA, "24681012C",
                                        "Farmacia 24h",
                                        "Pedro", "Sánchez",
                                        "345678", "555-555-5555", "farmacia3@example.com",
                                        new Direccion("C/ Elm St", "Anytown", "67890", "USA"));
                        farmaciaDAO.save(farmacia3);

                        Medicamento medicamento = new Medicamento("Aspirina", "Acido acetilsalicilico", "Bayer",
                                        "Analgesicos", 2);
                        medicamentoDAO.save(medicamento);
                        Medicamento medicamento2 = new Medicamento("Paracetamol", "Paracetamol", "GlaxoSmithKline",
                                        "Analgesicos", 2);
                        medicamentoDAO.save(medicamento2);
                        Medicamento medicamento3 = new Medicamento("Ibuprofeno", "Ibuprofeno", "Bayer", "Analgesicos",
                                        3);
                        medicamentoDAO.save(medicamento3);
                        Medicamento medicamento4 = new Medicamento("Amoxicilina", "Amoxicilina", "GlaxoSmithKline",
                                        "Antibioticos",
                                        2);
                        medicamentoDAO.save(medicamento4);
                        Medicamento medicamento5 = new Medicamento("Diclofenaco", "Diclofenaco", "Bayer",
                                        "Antiinflamatorios", 2);
                        medicamentoDAO.save(
                                        medicamento5);
                        Medicamento medicamento6 = new Medicamento("Metformina", "Metformina", "Merck",
                                        "Antidiabeticos", 3);
                        medicamentoDAO.save(medicamento6);
                        Medicamento medicamento7 = new Medicamento("Loratadina", "Loratadina", "Bayer",
                                        "Antihistaminicos", 1);
                        medicamentoDAO.save(
                                        medicamento7);
                        Medicamento medicamento8 = new Medicamento("Simvastatina", "Simvastatina", "Pfizer",
                                        "Estatinas", 1);
                        medicamentoDAO.save(medicamento8);
                        Medicamento medicamento9 = new Medicamento("Atenolol", "Atenolol", "Bristol-Myers Squibb",
                                        "Beta-bloqueadores",
                                        1);
                        medicamentoDAO.save(medicamento9);
                        Medicamento medicamento10 = new Medicamento("Esomeprazol", "Esomeprazol", "AstraZeneca",
                                        "Inhibidores de la bomba de protones", 1);
                        medicamentoDAO.save(medicamento10);
                        Medicamento medicamento11 = new Medicamento("Clonazepam", "Clonazepam", "Roche",
                                        "Benzodiacepinas", 1);
                        medicamentoDAO.save(medicamento11);
                        Medicamento medicamento12 = new Medicamento("Dextrometorfano", "Dextrometorfano",
                                        "GlaxoSmithKline",
                                        "Antitusigenos", 2);
                        medicamentoDAO.save(medicamento12);

                        Prescripcion prescripcion = new Prescripcion(
                                        medicamento,
                                        new Paciente("charlesj", "password311", "Charles", "Johnson", "68507239H",
                                                        "8888888888",
                                                        "9999999999",
                                                        "555-555-5555", "charlesj@example.com",
                                                        new SimpleDateFormat("dd/MM/yyyy").parse("08/08/1975"), medico4,
                                                        d2),
                                        medico1, 2.0, "Dolor de cabeza",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2022"),
                                        new SimpleDateFormat("dd/MM/yyyy").parse("15/05/2022"));
                        prescripcionDAO.save(prescripcion);
                        Prescripcion prescripcion2 = new Prescripcion(
                                        medicamento4,
                                        p1,
                                        medico2, 3.0, "Fiebre",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("15/05/2022"),
                                        new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2022"));
                        prescripcionDAO.save(prescripcion2);
                        Prescripcion prescripcion3 = new Prescripcion(
                                        medicamento4,
                                        p3,
                                        medico3, 1.5, "Dolor muscular",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("02/06/2022"),
                                        new SimpleDateFormat("dd/MM/yyyy").parse("15/06/2022"));
                        prescripcionDAO.save(prescripcion3);
                        Prescripcion prescripcion4 = new Prescripcion(
                                        medicamento4,
                                        p2,
                                        medico4, 1.0, "Infección respiratoria",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2022"),
                                        new SimpleDateFormat("dd/MM/yyyy").parse("15/07/2022"));
                        prescripcionDAO.save(prescripcion4);
                        Prescripcion prescripcion5 = new Prescripcion(
                                        medicamento4,
                                        p5,
                                        medico5, 0.5, "Anemia",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("15/07/2022"),
                                        new SimpleDateFormat("dd/MM/yyyy").parse("01/08/2022"));
                        prescripcionDAO.save(prescripcion5);
                        Prescripcion prescripcion6 = new Prescripcion(
                                        medicamento9,
                                        p1,
                                        medico1, 1.0, "Hipertensión",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("01/08/2022"),
                                        new SimpleDateFormat("dd/MM/yyyy").parse("15/08/2022"));
                        prescripcionDAO.save(prescripcion6);
                        Prescripcion prescripcion7 = new Prescripcion(
                                        medicamento9,
                                        p2,
                                        medico2, 2.0, "Artritis",
                                        new SimpleDateFormat("dd/MM/yyyy").parse("15/08/2022"),
                                        new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2022"));
                        prescripcionDAO.save(prescripcion7);
                        Receta receta = new Receta(prescripcion7,
                                        new SimpleDateFormat("dd/MM/yyyy").parse(
                                                        "15/08/2022"),
                                        new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2022"), 5);
                        recetaDAO.save(receta);
                        Receta receta2 = new Receta(prescripcion6,
                                        new SimpleDateFormat("dd/MM/yyyy").parse(
                                                        "01/08/2022"),
                                        new SimpleDateFormat("dd/MM/yyyy").parse("15/08/2022"), 2);
                        recetaDAO.save(receta2);

                } catch (ParseException e) {
                        System.out.println("Error en alguna fecha: no se insertó ninguna entidad del bloque afectado");
                        e.printStackTrace();
                }

        }

        private void recuperarCosas() {

                List<JpaRepository> daos = new ArrayList<>();

                daos.add(administradorDAO);
                daos.add(centroSaludDAO);
                daos.add(citaDAO);
                daos.add(farmaciaDAO);
                daos.add(medicamentoDAO);
                daos.add(medicoDAO);
                daos.add(pacienteDAO);
                daos.add(prescripcionDAO);
                daos.add(recetaDAO);

                for (JpaRepository dao : daos) {
                        System.out.println(dao.getClass().toString() + "\n\n");
                        for (Object obj : dao.findAll()) {
                                System.out.println(obj.toString());
                        }
                }
        }

}