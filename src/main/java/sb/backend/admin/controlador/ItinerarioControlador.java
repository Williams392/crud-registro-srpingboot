package sb.backend.admin.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sb.backend.admin.modelo.Itinerario;
import sb.backend.admin.servicio.ItinerarioServicio;
import sb.backend.admin.excepcion.RecursoNoEncontradoExcepcion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("transporte-api")
@CrossOrigin(value = "http://localhost:4200")
public class ItinerarioControlador {
    private static final Logger logger = LoggerFactory.getLogger(ItinerarioControlador.class);

    @Autowired
    private ItinerarioServicio itinerarioServicio;

    @GetMapping("/itinerarios")
    public List<Itinerario> obtenerDestinos() {
        List<Itinerario> itinerarios = this.itinerarioServicio.listarItinerario();
        logger.info("Destinos obtenidos");
        itinerarios.forEach(itinerario -> logger.info(itinerario.toString()));
        return itinerarios;
    }

    @PostMapping("/itinerarios")
    public Itinerario agregarDestino(@RequestBody Itinerario itinerario) {
        logger.info("Destino a agregar " + itinerario);
        return this.itinerarioServicio.guardarItinerario(itinerario);
    }

    @GetMapping("/itinerario/{id}")
    public ResponseEntity<Itinerario> obtenerDestinoPorId(@PathVariable int id) {
        Itinerario itinerario = this.itinerarioServicio.buscarItinerarioPorId(id);
        if (itinerario != null)
            return ResponseEntity.ok(itinerario);
        else
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
    }

    @PutMapping("/itinerario/{id}")
    public ResponseEntity<Itinerario> actualizarDestino(@PathVariable int id, @RequestBody Itinerario itinerarioRecibido) {
        Itinerario itinerario = this.itinerarioServicio.buscarItinerarioPorId(id);
        if (itinerario == null)
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        itinerario.setOrigen(itinerarioRecibido.getOrigen());
        itinerario.setDestino(itinerarioRecibido.getDestino());
        itinerario.setFecha_viaje(itinerarioRecibido.getFecha_viaje());
        itinerario.setAsientos(itinerarioRecibido.getAsientos());
        itinerario.setHoraSalida(itinerarioRecibido.getHoraSalida());
        itinerario.setHoraRetorno(itinerarioRecibido.getHoraRetorno());
        itinerario.setTipoServicio(itinerarioRecibido.getTipoServicio()); // pk
        itinerario.setNombreBus(itinerarioRecibido.getNombreBus()); // pk
        itinerario.setNombreChofer(itinerarioRecibido.getNombreChofer()); // pk
        this.itinerarioServicio.guardarItinerario(itinerario);
        return ResponseEntity.ok(itinerario);
    }

    @DeleteMapping("/itinerario/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarDestino(@PathVariable int id) {
        Itinerario itinerario = itinerarioServicio.buscarItinerarioPorId(id);
        if (itinerario == null)
            throw new RecursoNoEncontradoExcepcion("No se encontró el id " + id);
        this.itinerarioServicio.eliminarItinerarioPorId(itinerario.getIdItinerario());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
