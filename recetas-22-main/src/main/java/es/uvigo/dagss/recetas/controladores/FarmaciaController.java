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

import es.uvigo.dagss.recetas.entidades.Farmacia;
import es.uvigo.dagss.recetas.servicios.FarmaciaServicioImpl;

@RestController
@RequestMapping(path = "/api/farmacia", produces = MediaType.APPLICATION_JSON_VALUE)
public class FarmaciaController {

    @Autowired
    FarmaciaServicioImpl farmaciaServicio;

    @GetMapping()
    public ResponseEntity<List<Farmacia>> buscarTodos() {
        try {
            List<Farmacia> resultado = new ArrayList<>();

            resultado = farmaciaServicio.buscarTodos();

            if (resultado.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/establecimiento/{nombreEstablecimiento}")
    public ResponseEntity<List<Farmacia>> BuscarPorNombreEstablecimientoContaining(@PathVariable("nombreEstablecimiento") String nombreEstablecimiento) {
        List<Farmacia> farmaciaentidad = farmaciaServicio.BuscarPorNombreEstablecimientoContaining(nombreEstablecimiento);

        if (farmaciaentidad.isEmpty()) {
            return new ResponseEntity<>(farmaciaentidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @GetMapping(path = "/localidad/{localidad}")
    public ResponseEntity<List<Farmacia>> BuscarPorDireccionLocalidadContaining(@PathVariable("localidad") String localidad) {
        List<Farmacia> farmaciaentidad = farmaciaServicio.BuscarPorDireccionLocalidadContaining(localidad);

        if (farmaciaentidad.isEmpty()) {
            return new ResponseEntity<>(farmaciaentidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping(path = "/provincia/{provincia}")
    public ResponseEntity<List<Farmacia>> BuscarPorDireccionProvinciaContaining(@PathVariable("provincia") String provincia) {
        List<Farmacia> farmaciaentidad = farmaciaServicio.BuscarPorDireccionProvinciaContaining(provincia);

        if (farmaciaentidad.isEmpty()) {
            return new ResponseEntity<>(farmaciaentidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(path = "/login/{login}")
    public ResponseEntity<Farmacia> buscarPorId(@PathVariable("login") String login) {
        Optional<Farmacia> farmaciaentidad = farmaciaServicio.buscarPorId(login);

        if (farmaciaentidad.isPresent()) {
            return new ResponseEntity<>(farmaciaentidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(path = "{login}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("login") String login) {
        try {
            Optional<Farmacia> farmaciaentidad = farmaciaServicio.buscarPorId(login);
            if (farmaciaentidad.isPresent()) {
                farmaciaServicio.eliminar(farmaciaentidad.get().getLogin());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "{login}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Farmacia> modificar(@PathVariable("login") String login,
            @RequestBody Farmacia farmaciaentidad) {
        Optional<Farmacia> farmaciaEntidadOptional = farmaciaServicio.buscarPorId(login);

        if (farmaciaEntidadOptional.isPresent()) {
            Farmacia nuevoFarmaciaEntidad = farmaciaServicio.modificar(farmaciaentidad);
            return new ResponseEntity<>(nuevoFarmaciaEntidad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Farmacia> crear(@RequestBody Farmacia farmaciaentidad) {
        try {
            String login = farmaciaentidad.getLogin();
            if ((login != null) && !login.trim().isEmpty()) {
                Optional<Farmacia> farmaciaEntidadOptional = farmaciaServicio.buscarPorId(login);

                if (farmaciaEntidadOptional.isPresent()) {
                    Farmacia nuevoFarmaciaEntidad = farmaciaServicio.crear(farmaciaentidad);
                    URI uri = crearURIFarmaciaEntidad(nuevoFarmaciaEntidad);

                    return ResponseEntity.created(uri).body(nuevoFarmaciaEntidad);

                }
            }
            // No aporta DNI o DNI ya existe
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Construye la URI del nuevo recurso creado con POST
    private URI crearURIFarmaciaEntidad(Farmacia farmaciaentidad) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{login}")
                .buildAndExpand(farmaciaentidad.getLogin())
                .toUri();
    }

}
