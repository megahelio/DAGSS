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

import es.uvigo.dagss.recetas.entidades.Prescripcion;
import es.uvigo.dagss.recetas.servicios.PacienteServicioImpl;
import es.uvigo.dagss.recetas.servicios.PrescripcionServicioImpl;

@RestController
@RequestMapping(path = "/api/prescripcion", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrescripcionController {

    @Autowired
    PrescripcionServicioImpl prescripcionServicio;
    @Autowired
    PacienteServicioImpl pacienteServicio;

    @GetMapping()
    public ResponseEntity<List<Prescripcion>> buscarTodos() {
        try {
            List<Prescripcion> resultado = new ArrayList<>();

            resultado = prescripcionServicio.buscarTodos();

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Prescripcion> buscarPorId(@PathVariable("id") Long id) {
        Optional<Prescripcion> prescripcionentidad = prescripcionServicio.buscarPorId(id);

        if (prescripcionentidad.isPresent()) {
            return new ResponseEntity<>(prescripcionentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/paciente/{id}")
    public ResponseEntity<List<Prescripcion>> buscarPorPacienteContaining(@PathVariable("id") String nombre) {
        List<Prescripcion> prescripcionentidad = new ArrayList<>();
        prescripcionentidad = prescripcionServicio
                .buscarPorPacienteContaining(pacienteServicio.buscarPorId(nombre).get());

        if (prescripcionentidad.isEmpty()) {
            return new ResponseEntity<>(prescripcionentidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") Long id) {
        try {
            Optional<Prescripcion> prescripcionentidad = prescripcionServicio.buscarPorId(id);
            if (prescripcionentidad.isPresent()) {
                prescripcionServicio.eliminar(prescripcionentidad.get().getId());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Prescripcion> modificar(@PathVariable("id") Long id,
            @RequestBody Prescripcion prescripcionentidad) {
        Optional<Prescripcion> prescripcionEntidadOptional = prescripcionServicio.buscarPorId(id);

        if (prescripcionEntidadOptional.isPresent()) {
            Prescripcion nuevoPrescripcionEntidad = prescripcionServicio.modificar(prescripcionentidad);
            return new ResponseEntity<>(nuevoPrescripcionEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Prescripcion> crear(@RequestBody Prescripcion prescripcionentidad) {
        try {
            Long id = prescripcionentidad.getId();
            if ((id != null)) {
                Optional<Prescripcion> prescripcionEntidadOptional = prescripcionServicio.buscarPorId(id);

                if (prescripcionEntidadOptional.isPresent()) {
                    Prescripcion nuevoPrescripcionEntidad = prescripcionServicio.crear(prescripcionentidad);
                    URI uri = crearURIPrescripcionEntidad(nuevoPrescripcionEntidad);

                    return ResponseEntity.created(uri).body(nuevoPrescripcionEntidad);

                }
            }
            // No aporta DNI o DNI ya existe
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Construye la URI del nuevo recurso creado con POST
    private URI crearURIPrescripcionEntidad(Prescripcion prescripcionentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(prescripcionentidad.getId())
                .toUri();
    }

}
