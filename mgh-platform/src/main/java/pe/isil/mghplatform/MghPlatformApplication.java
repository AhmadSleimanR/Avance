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
import java.util.List;

@SpringBootApplication
public class MghPlatformApplication implements CommandLineRunner {

    @Autowired
    RestTemplate restTemplate;

    final static String URL = "http://localhost:8080/api";

    public static void main(String[] args) {
        SpringApplication.run(MghPlatformApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Override
    public void run(String... args) throws Exception {

        List reservaList = restTemplate.getForObject(URL + "/reserva", List.class);

        reservaList.forEach(System.out::println);

        Pago pago = new Pago();
        pago.setTipo("Efectivo");
        pago.setTotal(1500);

        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setNombre("Hotel las Flores");
        alojamiento.setNumero_de_habitaciones(30);
        alojamiento.setTipo("Hotel Turistico");
        alojamiento.setValoracion(5);
        alojamiento.setUbigeo(01);

        Habitacion habitacion = new Habitacion();
        habitacion.addAlojamiento();
        habitacion.setDescripcion("Habitación Ejecutiva");
        habitacion.setTipo("Ejecutiva");
        habitacion.setNumero("5");
        habitacion.setPrecio("1500 dolares");

        Usuario usuario = new Usuario();
        usuario.setNombre("Jeremy");
        usuario.setApellido("Tornero");
        usuario.setContraseña("1234");
        usuario.setEmail("jeremy@gmail.com");
        usuario.setFoto("");

        Reserva reserva = new Reserva();
        reserva.addUsuarios(usuario);
        reserva.addHabitaciones(habitacion);
        reserva.addPagos(pago);
        reserva.setCantidad_de_personas(3);
        reserva.setFechaIngreso(LocalDate.of(19,07,15));
        reserva.setFechaSalida(LocalDate.of(19,10,30));
        reserva.setComentarios("");


        Reserva reserva1 = restTemplate.postForObject(URL + "/reservas", reserva, Reserva.class);

        System.out.println(reserva1);

    }
}
