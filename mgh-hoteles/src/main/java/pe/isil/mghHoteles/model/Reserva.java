package pe.isil.mghHoteles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_generator")
    @SequenceGenerator(name = "reserva_generator", sequenceName = "reserva_seq")
    @Id
    private  Integer idReserva;
    private  String comentarios;
    private  LocalDate fechaIngreso;
    private  LocalDate fechaSalida;
    private  Integer cantidadDePersonas;

    @OneToOne(mappedBy = "reserva", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Usuario usuario;
    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Pago> pagos = new ArrayList<>();
    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Habitacion> habitaciones = new ArrayList<>();

    @Override
    public String toString(){
        return "Id: "+idReserva;
    }
}
