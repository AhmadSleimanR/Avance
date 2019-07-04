package pe.isil.mghplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario implements Serializable {

    private Integer idUsuario;
    private String nombres;
    private String apellidos;
    private String contrasena;
    private String codUsuario;
    private String email;
    private String foto;

}
