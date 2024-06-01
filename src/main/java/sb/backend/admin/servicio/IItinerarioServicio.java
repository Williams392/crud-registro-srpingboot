package sb.backend.admin.servicio;

import sb.backend.admin.modelo.Itinerario;
import java.util.List;

public interface IItinerarioServicio {

    List<Itinerario> listarItinerario();
    Itinerario buscarItinerarioPorId(Integer idItinerario);
    Itinerario guardarItinerario(Itinerario itinerario);
    void eliminarItinerarioPorId(Integer idItinerario);
}
