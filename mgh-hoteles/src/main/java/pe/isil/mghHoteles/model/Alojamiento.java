package pe.isil.mghHoteles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Alojamiento implements Serializable {

    private Integer IdAlojamiento;
    private String nombre;
    private Integer valoracion;
    private String tipo;
    private String codAlojamiento;
    private Integer numero_de_habitaciones;
    private Integer ubigeo;

    @OneToMany(mappedBy = "alojamiento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones = new ArrayList<>();
    @OneToMany(mappedBy = "alojamiento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Foto> fotos = new ArrayList<>();
}
