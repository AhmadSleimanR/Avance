package pe.isil.mghHoteles.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"reserva", "handler"})
public class Usuario implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer IdUsuario;
    private String nombres;
    private String apellidos;
    private String contrasena;
    private String codUsuario;
    private String email;
    private String foto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdReserva")
    private Reserva reserva;
}
