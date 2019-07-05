package pe.isil.mghplatform.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Alojamiento implements Serializable {
    private Integer idAlojamiento;
    private String nombre;
    private Integer valoracion;
    private String tipo;
    private String codAlojamiento;
    private Integer numeroDeHabitaciones;
    private Integer ubigeo;


    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Foto> fotos = new ArrayList<>();

    @Override
    public String toString(){
        return "Id: "+idAlojamiento;
    }
}
