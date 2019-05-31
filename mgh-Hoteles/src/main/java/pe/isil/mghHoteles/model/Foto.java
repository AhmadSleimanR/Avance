package pe.isil.mghHoteles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Foto implements Serializable {

    private Integer IdFoto;
    private String urlFoto;
    private String codEntidad;

}