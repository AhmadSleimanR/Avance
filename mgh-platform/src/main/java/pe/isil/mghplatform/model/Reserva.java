package pe.isil.mghplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reserva implements Serializable {

    private  Integer IdReserva;
    private  String comentarios;
    private LocalDate fechaIngreso;
    private  LocalDate fechaSalida;
    private  Integer cantidad_de_personas;
    private List<Usuario> usuarios;
    private  List<Habitacion> habitaciones;
    private  List<Pago> pagos;


    public void addUsuarios(Usuario ... usuariosArgs){
        usuarios = Arrays.asList(usuariosArgs);
    }

    public void addHabitaciones(Habitacion ... habitacionesArgs) {
        habitaciones = Arrays.asList(habitacionesArgs);
    }

    public void addPagos(Pago ... pagosArgs) {
        pagos = Arrays.asList(pagosArgs);
    }
}
