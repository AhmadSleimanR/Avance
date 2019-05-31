package pe.isil.mghplatform.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Alojamiento implements Serializable {

    private Integer IdAlojamiento;
    private String nombre;
    private Integer valoracion;
    private String tipo;
    private Integer numero_de_habitaciones;
    private Integer ubigeo;
}
