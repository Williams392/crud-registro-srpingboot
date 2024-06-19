package sb.backend.admin.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sb.backend.admin.modelo.TipoServicio;

public interface TipoServicioRepositorio extends JpaRepository<TipoServicio, Integer>{
}
