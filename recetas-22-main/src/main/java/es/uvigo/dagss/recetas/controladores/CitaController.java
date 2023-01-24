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

import es.uvigo.dagss.recetas.entidades.Cita;
import es.uvigo.dagss.recetas.entidades.Paciente;
import es.uvigo.dagss.recetas.servicios.CitaServicioImpl;
import es.uvigo.dagss.recetas.servicios.PacienteServicioImpl;

@RestController
@RequestMapping(path = "/api/cita", produces = MediaType.APPLICATION_JSON_VALUE)
public class CitaController {

    @Autowired
    CitaServicioImpl citaServicio;
    @Autowired
    PacienteServicioImpl pacienteServicio;

    @GetMapping()
    public ResponseEntity<List<Cita>> buscarTodos() {
        try {
            List<Cita> resultado = new ArrayList<>();

            resultado = citaServicio.buscarTodos();

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Cita> buscarPorId(@PathVariable("id") Long id) {
        Optional<Cita> citaentidad = citaServicio.buscarPorId(id);

        if (citaentidad.isPresent()) {
            return new ResponseEntity<>(citaentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/paciente/{id}")
    public ResponseEntity<List<Cita>> BuscarPorPaciente(@PathVariable("id") String id) {
        Paciente paciente = pacienteServicio.buscarPorId(id).get();
        List<Cita> citaentidad = citaServicio.buscarPorPaciente(paciente);
        
        if (!citaentidad.isEmpty()) {
            return new ResponseEntity<>(citaentidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") Long id) {
        try {
            Optional<Cita> citaentidad = citaServicio.buscarPorId(id);
            if (citaentidad.isPresent()) {
                citaServicio.eliminar(citaentidad.get().getId());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cita> modificar(@PathVariable("id") Long id,
            @RequestBody Cita citaentidad) {
        Optional<Cita> citaEntidadOptional = citaServicio.buscarPorId(id);

        if (citaEntidadOptional.isPresent()) {
            Cita nuevoCitaEntidad = citaServicio.modificar(citaentidad);
            return new ResponseEntity<>(nuevoCitaEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cita> crear(@RequestBody Cita citaentidad) {
        try {
            Long id = citaentidad.getId();
            if ((id != null)) {
                Optional<Cita> citaEntidadOptional = citaServicio.buscarPorId(id);

                if (citaEntidadOptional.isPresent()) {
                    Cita nuevoCitaEntidad = citaServicio.crear(citaentidad);
                    URI uri = crearURICitaEntidad(nuevoCitaEntidad);

                    return ResponseEntity.created(uri).body(nuevoCitaEntidad);

                }
            }
            // No aporta DNI o DNI ya existe
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Construye la URI del nuevo recurso creado con POST
    private URI crearURICitaEntidad(Cita citaentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(citaentidad.getId())
                .toUri();
    }

}
