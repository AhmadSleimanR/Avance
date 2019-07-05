package pe.isil.mghplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Habitacion implements Serializable {
    private Integer idHabitacion;
    private String descripcion;
    private Integer tipo;
    private String numero;
    private String codHabitacion;
    private String precio;

    @Override
    public String toString(){
        return "Id: "+idHabitacion;
    }
}
