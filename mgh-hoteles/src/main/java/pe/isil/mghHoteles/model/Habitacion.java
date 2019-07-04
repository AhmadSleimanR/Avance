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
@JsonIgnoreProperties({"alojamiento", "reserva", "handler"})
public class Habitacion implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habitacion_generator")
    @SequenceGenerator(name = "habitacion_generator", sequenceName = "habitacion_seq")
    @Id
    private Integer idHabitacion;
    private String descripcion;
    private Integer tipo;
    private String numero;
    private String codHabitacion;
    private String precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAlojamiento", referencedColumnName = "idAlojamiento")
    private Alojamiento alojamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReserva", referencedColumnName = "idReserva")
    private Reserva reserva;

    @Override
    public String toString(){
        return "Id: "+idHabitacion;
    }
}
