package pe.isil.mghplatform.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Habitacion implements Serializable {

    private Integer IdHabitacion;
    private String descripcion;
    private String tipo;
    private String numero;
    private String precio;
    private List<Alojamiento> alojamientos;

    public void addAlojamiento(Alojamiento ... alojamientosArgs){
        alojamientos = Arrays.asList(alojamientosArgs);
    }
}
