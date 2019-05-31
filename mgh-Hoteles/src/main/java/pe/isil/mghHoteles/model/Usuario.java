package pe.isil.mghHoteles.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario implements Serializable {

    private Integer IdUsuario;
    private String nombres;
    private String apellidos;
    private String contraseña;
    private String codUsuario;
    private String email;
    private String foto;

}
