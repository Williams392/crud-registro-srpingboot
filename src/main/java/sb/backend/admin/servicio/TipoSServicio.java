package sb.backend.admin.servicio;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import sb.backend.admin.modelo.TipoServicio;
import sb.backend.admin.repositorio.TipoServicioRepositorio;

import java.util.List;

@Service
public class TipoSServicio implements ITipoSServicio{

    @Autowired
    private TipoServicioRepositorio iTipoSServicio;

    @Override
    public List<TipoServicio> listarTipoServicio() {
        return this.iTipoSServicio.findAll();
    }

    @Override
    public TipoServicio buscarTipoServicioPorId(Integer idTipoServicio) {
        return this.iTipoSServicio.findById(idTipoServicio).orElse(null);
    }

    @Override
    public TipoServicio guardarTipoServicio(TipoServicio tipoServicio) {
        return this.iTipoSServicio.save(tipoServicio);
    }

    @Override
    public void eliminarTipoServicioPorId(Integer idTipoServicio) {
        this.iTipoSServicio.deleteById(idTipoServicio);
    }
}
