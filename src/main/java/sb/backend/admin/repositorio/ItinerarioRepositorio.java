package sb.backend.admin.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.backend.admin.modelo.Itinerario;

import java.util.List;


public interface ItinerarioRepositorio extends JpaRepository<Itinerario, Integer> {
}







