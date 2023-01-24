package es.uvigo.dagss.recetas.controladores;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.servicios.PacienteServicioImpl;

@RestController
@RequestMapping(path = "/api/paciente", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {

    @Autowired
    PacienteServicioImpl pacienteServicio;

    @GetMapping()
    public ResponseEntity<List<Paciente>> buscarTodos() {
        try {
            List<Paciente> resultado = new ArrayList<>();

            resultado = pacienteServicio.buscarTodos();

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "{login}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable("login") String login) {
        Optional<Paciente> pacienteentidad = pacienteServicio.buscarPorId(login);

        if (pacienteentidad.isPresent()) {
            return new ResponseEntity<>(pacienteentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{login}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("login") String login) {
        try {
            Optional<Paciente> pacienteentidad = pacienteServicio.buscarPorId(login);
            if (pacienteentidad.isPresent()) {
                pacienteServicio.eliminar(pacienteentidad.get().getLogin());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{login}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente> modificar(@PathVariable("login") String login,
            @RequestBody Paciente pacienteentidad) {
        Optional<Paciente> pacienteEntidadOptional = pacienteServicio.buscarPorId(login);

        if (pacienteEntidadOptional.isPresent()) {
            Paciente nuevoPacienteEntidad = pacienteServicio.modificar(pacienteentidad);
            return new ResponseEntity<>(nuevoPacienteEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente> crear(@RequestBody Paciente pacienteentidad) {
        try {
            String login = pacienteentidad.getLogin();
            if ((login != null) && !login.trim().isEmpty()) {
                Optional<Paciente> pacienteEntidadOptional = pacienteServicio.buscarPorId(login);

                if (pacienteEntidadOptional.isPresent()) {
                    Paciente nuevoPacienteEntidad = pacienteServicio.crear(pacienteentidad);
                    URI uri = crearURIPacienteEntidad(nuevoPacienteEntidad);

                    return ResponseEntity.created(uri).body(nuevoPacienteEntidad);

                }
            }
            // No aporta DNI o DNI ya existe
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Construye la URI del nuevo recurso creado con POST
    private URI crearURIPacienteEntidad(Paciente pacienteentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{login}")
                .buildAndExpand(pacienteentidad.getLogin())
                .toUri();
    }

}
