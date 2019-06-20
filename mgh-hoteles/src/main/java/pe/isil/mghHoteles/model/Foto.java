package pe.isil.mghHoteles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"alojamiento", "usuario", "handler"})
public class Foto implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer IdFoto;
    private String urlFoto;
    private String codEntidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdAlojamiento")
    private Alojamiento alojamiento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdUsuario")
    private Usuario usuario;
}