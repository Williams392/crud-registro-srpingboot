package sb.backend.admin.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.backend.admin.modelo.Pasajero;

public interface PasajeroRepositorio extends JpaRepository<Pasajero, Integer>{
}
