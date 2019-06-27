package pe.isil.mghHoteles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"reserva", "handler"})
public class Pago implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pago_generator")
    @SequenceGenerator(name = "pago_generator", sequenceName = "pago_seq")
    @Id
    private Integer idPago;
    private String tipo;
    private Integer total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdReserva")
    private Reserva reserva;
}
