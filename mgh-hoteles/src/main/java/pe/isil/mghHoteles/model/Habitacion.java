package pe.isil.mghHoteles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"alojamiento", "handler"})
public class Habitacion implements Serializable {

    private Integer IdHabitacion;
    private String descripcion;
    private Integer tipo;
    private String numero;
    private String codHabitacion;
    private String precio;
    private List<Alojamiento> alojamientos;

    public void addAlojamiento(Alojamiento ... alojamientosArgs){
        alojamientos = Arrays.asList(alojamientosArgs);
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdAlojamiento")
    private Alojamiento alojamiento;
}
