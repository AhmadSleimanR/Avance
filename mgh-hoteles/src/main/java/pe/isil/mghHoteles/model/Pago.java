package pe.isil.mghHoteles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"reserva", "handler"})
public class Pago implements Serializable {

    private Integer IdPago;
    private String tipo;
    private Integer total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdReserva")
    private Reserva reserva;
}
