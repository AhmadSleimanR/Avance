package pe.isil.mghplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pe.isil.mghplatform.model.Reserva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReservaController {
	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@GetMapping( {"/", "/index"})
	public String index(){
		return "index";
	}

	@GetMapping("/reserva")
	public String getReservaList(Model model){
		Reserva[] reservas = restTemplate.getForObject( "http://localhost:8080/api/reservas", Reserva[].class);
		List<Reserva> reservaList = Optional.ofNullable(reservas).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("reserva", reservaList);
		return "reserva";
	}

	@GetMapping("/reserva/add")
	public String addReserva(Model model){
		model.addAttribute("reserva", new Reserva());
		return "reserva-add";
	}

	@PostMapping("/reserva/save")
	public String saveReserva(Reserva reserva, Model model){
		restTemplate.postForObject("http://localhost:8080/api/reservas/", reserva, Reserva.class);
		Reserva[] reservas = restTemplate.getForObject( "http://localhost:8080/api/reservas", Reserva[].class);
		List<Reserva> reservaList = Optional.ofNullable(reservas).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("reserva", reservaList);
		return "reserva";
	}

	@GetMapping("/reserva/edit/{sku}")
	public String getReservaForEdit(@PathVariable String sku,
										Model model){
		Reserva reserva = restTemplate.getForObject( "http://localhost:8080/api/reservas/"+sku, Reserva.class);
		model.addAttribute("reserva",
				reserva);
		return "reserva-edit";
	}

	@PostMapping("/reserva/update/{sku}")
	public String updateReserva(@PathVariable String sku,
									Reserva reserva,
									Model model){
		restTemplate.put("http://localhost:8080/api/reservas/"+sku, reserva);
		Reserva[] reservas = restTemplate.getForObject( "http://localhost:8080/api/reservas", Reserva[].class);
		List<Reserva> reservaList = Optional.ofNullable(reservas).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("reserva", reservaList);
		return "reserva";
	}

	@GetMapping("/reserva/delete/{sku}")
	public String deleteReserva(@PathVariable String sku,
									Model model){
		restTemplate.delete("http://localhost:8080/api/reservas/"+sku);
		Reserva[] reservas = restTemplate.getForObject( "http://localhost:8080/api/reservas", Reserva[].class);
		List<Reserva> reservaList = Optional.ofNullable(reservas).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("reserva", reservaList);
		return "reserva";
	}
}