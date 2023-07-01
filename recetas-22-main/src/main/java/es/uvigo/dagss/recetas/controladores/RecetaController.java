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
import es.uvigo.dagss.recetas.entidades.Receta;
import es.uvigo.dagss.recetas.servicios.PacienteServicioImpl;
import es.uvigo.dagss.recetas.servicios.PrescripcionServicioImpl;
import es.uvigo.dagss.recetas.servicios.RecetaServicioImpl;

@RestController
@RequestMapping(path = "/api/receta", produces = MediaType.APPLICATION_JSON_VALUE)
public class RecetaController {

    @Autowired
    RecetaServicioImpl recetaServicio;
    @Autowired
    PacienteServicioImpl pacienteServicio;
    @Autowired
    PrescripcionServicioImpl prescripcionServicio;

    @GetMapping()
    public ResponseEntity<List<Receta>> buscarTodos() {
        try {
            List<Receta> resultado = new ArrayList<>();

            resultado = recetaServicio.buscarTodos();

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Receta> buscarPorId(@PathVariable("id") Long id) {
        Optional<Receta> recetaentidad = recetaServicio.buscarPorId(id);

        if (recetaentidad.isPresent()) {
            return new ResponseEntity<>(recetaentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/recetas/{id}")
    public ResponseEntity<List<Receta>> BuscarPorPacienteContaining(@PathVariable("id") String idPaciente) {
        List<Receta> recetas = new ArrayList<>();
        for (Prescripcion prescripcion : prescripcionServicio
                .buscarPorPacienteContaining(pacienteServicio.buscarPorId(idPaciente).get())) {
            recetas.addAll(recetaServicio.findByPrenscripcionRecetaContaining(prescripcion));
        }

        if (recetas.isEmpty()) {
            return new ResponseEntity<>(recetas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") Long id) {
        try {
            Optional<Receta> recetaentidad = recetaServicio.buscarPorId(id);
            if (recetaentidad.isPresent()) {
                recetaServicio.eliminar(recetaentidad.get().getId());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receta> modificar(@PathVariable("id") Long id,
            @RequestBody Receta recetaentidad) {
        Optional<Receta> recetaEntidadOptional = recetaServicio.buscarPorId(id);

        if (recetaEntidadOptional.isPresent()) {
            Receta nuevoRecetaEntidad = recetaServicio.modificar(recetaentidad);
            return new ResponseEntity<>(nuevoRecetaEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Receta> crear(@RequestBody Receta recetaentidad) {
        try {
            Long id = recetaentidad.getId();
            if ((id != null)) {
                Optional<Receta> recetaEntidadOptional = recetaServicio.buscarPorId(id);

                if (recetaEntidadOptional.isPresent()) {
                    Receta nuevoRecetaEntidad = recetaServicio.crear(recetaentidad);
                    URI uri = crearURIRecetaEntidad(nuevoRecetaEntidad);

                    return ResponseEntity.created(uri).body(nuevoRecetaEntidad);

                }
            }
            // No aporta DNI o DNI ya existe
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Construye la URI del nuevo recurso creado con POST
    private URI crearURIRecetaEntidad(Receta recetaentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(recetaentidad.getId())
                .toUri();
    }

}
