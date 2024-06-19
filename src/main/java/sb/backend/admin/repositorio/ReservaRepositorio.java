package sb.backend.admin.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.backend.admin.modelo.Reserva;

public interface ReservaRepositorio extends JpaRepository<Reserva, Integer>{

}
