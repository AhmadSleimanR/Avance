package pe.isil.mghHoteles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.isil.mghHoteles.model.*;
import pe.isil.mghHoteles.service.AlojamientoService;
import pe.isil.mghHoteles.service.ReservaService;

import java.time.LocalDate;

@SpringBootApplication
public class MghHotelesApplication implements CommandLineRunner {

    @Autowired
    ReservaService reservaService;
    AlojamientoService alojamientoService;

    public static void main(String[] args) {
        SpringApplication.run(MghHotelesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Pago pago = new Pago();
        pago.setTipo("Efectivo");
        pago.setTotal(1500);

        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setNombre("Hotel las Flores");
        alojamiento.setNumero_de_habitaciones(30);
        alojamiento.setTipo("Hotel Turistico");
        alojamiento.setValoracion(5);
        alojamiento.setUbigeo(01);
        alojamiento.setCodAlojamiento("ALO01");

        Habitacion habitacion = new Habitacion();
        habitacion.addAlojamiento();
        habitacion.setDescripcion("Habitación Ejecutiva");
        habitacion.setTipo(3);
        habitacion.setNumero("5");
        habitacion.setPrecio("1500 dolares");
        habitacion.setCodHabitacion("HAB01");

        Usuario usuario = new Usuario();
        usuario.setNombres("Jeremy");
        usuario.setApellidos("Tornero");
        usuario.setContraseña("1234");
        usuario.setEmail("jeremy@gmail.com");
        usuario.setFoto("");
        usuario.setCodUsuario("USU01");

        Reserva reserva = new Reserva();
        reserva.addUsuarios(usuario);
        reserva.addHabitaciones(habitacion);
        reserva.addPagos(pago);
        reserva.setCantidad_de_personas(3);
        reserva.setFechaIngreso(LocalDate.of(19,07,15));
        reserva.setFechaSalida(LocalDate.of(19,10,30));
        reserva.setComentarios("");

        reservaService.create(reserva);
        System.out.println("reserva add success!");

        alojamientoService.create(alojamiento);
        System.out.println("alojamiento add success");
    }
}
