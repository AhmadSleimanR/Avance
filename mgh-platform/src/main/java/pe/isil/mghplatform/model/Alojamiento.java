package pe.isil.mghplatform.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alojamiento implements Serializable {

    private Integer idAlojamiento;
    private String nombre;
    private Integer valoracion;
    private String tipo;
    private String codAlojamiento;
    private Integer numeroDeHabitaciones;
    private Integer ubigeo;

    private List<Foto> fotos;
    private List<Habitacion> habitaciones;
}
