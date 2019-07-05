package pe.isil.mghplatform.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"reserva", "handler"})
public class Usuario implements Serializable {
    private Integer idUsuario;
    private String nombres;
    private String apellidos;
    private String contrasena;
    private String codUsuario;
    private String email;

    private Foto foto;

    @Override
    public String toString(){
        return "Id: "+idUsuario;
    }
}
