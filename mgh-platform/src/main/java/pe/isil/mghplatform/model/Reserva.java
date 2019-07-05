package pe.isil.mghplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reserva implements Serializable {
    private  Integer idReserva;
    private  String comentarios;
    private  LocalDate fechaIngreso;
    private  LocalDate fechaSalida;
    private  Integer cantidadDePersonas;

    private Usuario usuario;
    private List<Pago> pagos = new ArrayList<>();
    private List<Habitacion> habitaciones = new ArrayList<>();

    @Override
    public String toString(){
        return "Id: "+idReserva;
    }
}
