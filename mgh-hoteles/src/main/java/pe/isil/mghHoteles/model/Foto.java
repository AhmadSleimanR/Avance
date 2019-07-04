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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foto_generator")
    @SequenceGenerator(name = "foto_generator", sequenceName = "foto_seq")
    @Id
    private Integer idFoto;
    private String urlFoto;
    private String codEntidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAlojamiento", referencedColumnName = "idAlojamiento")
    private Alojamiento alojamiento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario usuario;

    @Override
    public String toString(){
        return "Id: "+idFoto;
    }
}