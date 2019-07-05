package pe.isil.mghplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Foto implements Serializable {
    private Integer idFoto;
    private String urlFoto;
    private String codEntidad;

    @Override
    public String toString(){
        return "Id: "+idFoto;
    }
}