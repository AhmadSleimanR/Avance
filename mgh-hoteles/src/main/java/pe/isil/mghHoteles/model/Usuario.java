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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
    @SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_seq")
    @Id
    private Integer idUsuario;
    private String nombres;
    private String apellidos;
    private String contrasena;
    private String codUsuario;
    private String email;

    @OneToOne(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Foto foto;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReserva", referencedColumnName = "idReserva")
    private Reserva reserva;

    @Override
    public String toString(){
        return "Id: "+idUsuario;
    }
}
