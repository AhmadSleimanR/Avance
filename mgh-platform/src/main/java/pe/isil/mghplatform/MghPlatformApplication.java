package pe.isil.mghplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import pe.isil.mghplatform.model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
@SpringBootApplication
public class MghPlatformApplication implements CommandLineRunner {

    @Autowired
    RestTemplate restTemplate;

    private final static String URL = "http://localhost:8080/api";

    public static void main(String[] args) {
        SpringApplication.run(MghPlatformApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Override
    public void run(String... args) throws Exception {

        List reservaList = restTemplate.getForObject(URL + "/reservas", List.class);

        reservaList.forEach(System.out::println);

        Pago pago = new Pago();
        pago.setTipo("Efectivo");
        pago.setTotal(1500);
        restTemplate.postForObject(URL + "/pagos/", pago, Pago.class);

        Habitacion habitacion = new Habitacion();
        habitacion.setDescripcion("Habitación Ejecutiva");
        habitacion.setTipo(3);
        habitacion.setNumero("5");
        habitacion.setCodHabitacion("HAB02");
        habitacion.setPrecio("1500 dolares");
        restTemplate.postForObject(URL + "/habitaciones/", habitacion, Habitacion.class);

        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setNombre("Hotel las Flores");
        alojamiento.setNumeroDeHabitaciones(30);
        alojamiento.setTipo("Hotel Turistico");
        alojamiento.setValoracion(5);
        alojamiento.setUbigeo(13);
        alojamiento.setHabitaciones(Arrays.asList(habitacion));
        restTemplate.postForObject(URL + "/alojamientos/", alojamiento, Alojamiento.class);

        Usuario usuario = new Usuario();
        usuario.setNombres("Jeremy");
        usuario.setApellidos("Tornero");
        usuario.setContrasena("1234");
        usuario.setCodUsuario("USU02");
        usuario.setEmail("jeremy@gmail.com");
        restTemplate.postForObject(URL + "/usuarios/", usuario, Usuario.class);

        Reserva reserva = new Reserva();
        reserva.setCantidadDePersonas(3);
        reserva.setFechaIngreso(LocalDate.of(19,7,15));
        reserva.setFechaSalida(LocalDate.of(19,10,30));
        reserva.setComentarios("");
        reserva.setPagos(Arrays.asList(pago));
        reserva.setHabitaciones(Arrays.asList(habitacion));
        reserva.setUsuario(usuario);
        restTemplate.postForObject(URL + "/reservas/", reserva, Reserva.class);
    }
}
