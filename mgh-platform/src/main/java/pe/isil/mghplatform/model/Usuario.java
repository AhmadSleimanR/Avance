package pe.isil.mghplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario implements Serializable {

    private Integer IdUsuario;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String email;
    private String foto;

}
