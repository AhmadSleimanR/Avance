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
@JsonIgnoreProperties({"alojamiento", "reserva", "handler"})
public class Habitacion implements Serializable {

    private Integer IdHabitacion;
    private String descripcion;
    private Integer tipo;
    private String numero;
    private String codHabitacion;
    private String precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdAlojamiento")
    private Alojamiento alojamiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdReserva")
    private Reserva reserva;
}
