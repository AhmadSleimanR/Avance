package pe.isil.mghplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reserva implements Serializable {

    private  Integer idReserva;
    private  String comentarios;
    private  LocalDate fechaIngreso;
    private  LocalDate fechaSalida;
    private  Integer cantidadDePersonas;

}
