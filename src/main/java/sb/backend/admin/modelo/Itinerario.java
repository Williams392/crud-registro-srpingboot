package sb.backend.admin.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Itinerario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItinerario;

    private String origen;
    private String destino;
    private String fecha_viaje;
    private Double asientos;
    private String horaSalida;
    private String horaRetorno;

    @ManyToOne
    @JoinColumn(name = "idTipoServicio")
    private TipoServicio tipoServicio; // nombre y precio


    @ManyToOne
    @JoinColumn(name = "idBus")
    private Bus nombreBus;

    @ManyToOne
    @JoinColumn(name = "idChofer")
    private Chofer nombreChofer;

}
