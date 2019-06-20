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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  Integer IdReserva;
    private  String comentarios;
    private  LocalDate fechaIngreso;
    private  LocalDate fechaSalida;
    private  Integer cantidad_de_personas;

    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<>();
    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Pago> pagos = new ArrayList<>();
    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones = new ArrayList<>();
}
