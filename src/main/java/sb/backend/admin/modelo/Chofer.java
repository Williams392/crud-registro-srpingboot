package sb.backend.admin.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chofer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChofer;
    private String chofer;
    private String direccion;
    private String numBrevete;

    @ManyToOne
    @JoinColumn(name = "idBus")
    private Bus bus;
}