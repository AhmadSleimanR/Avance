package pe.isil.mghplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pe.isil.mghplatform.model.Habitacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class HabitacionController {
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

	@GetMapping("/habitacion")
	public String getHabitacionList(Model model){
		Habitacion[] habitaciones = restTemplate.getForObject( "http://localhost:8080/api/habitaciones", Habitacion[].class);
		List<Habitacion> habitacionList = Optional.ofNullable(habitaciones).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("habitacion", habitacionList);
		return "habitacion";
	}

	@GetMapping("/habitacion/add")
	public String addHabitacion(Model model){
		model.addAttribute("habitacion", new Habitacion());
		return "habitacion-add";
	}

	@PostMapping("/habitacion/save")
	public String saveHabitacion(Habitacion habitacion, Model model){
		restTemplate.postForObject("http://localhost:8080/api/habitaciones/", habitacion, Habitacion.class);
		Habitacion[] habitaciones = restTemplate.getForObject( "http://localhost:8080/api/habitaciones", Habitacion[].class);
		List<Habitacion> habitacionList = Optional.ofNullable(habitaciones).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("habitacion", habitacionList);
		return "habitacion";
	}

	@GetMapping("/habitacion/edit/{sku}")
	public String getHabitacionForEdit(@PathVariable String sku,
										Model model){
		Habitacion habitacion = restTemplate.getForObject( "http://localhost:8080/api/habitaciones/"+sku, Habitacion.class);
		model.addAttribute("habitacion",
				habitacion);
		return "habitacion-edit";
	}

	@PostMapping("/habitacion/update/{sku}")
	public String updateHabitacion(@PathVariable String sku,
									Habitacion habitacion,
									Model model){
		restTemplate.put("http://localhost:8080/api/habitaciones/"+sku, habitacion);
		Habitacion[] habitaciones = restTemplate.getForObject( "http://localhost:8080/api/habitaciones", Habitacion[].class);
		List<Habitacion> habitacionList = Optional.ofNullable(habitaciones).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("habitacion", habitacionList);
		return "habitacion";
	}

	@GetMapping("/habitacion/delete/{sku}")
	public String deleteHabitacion(@PathVariable String sku,
									Model model){
		restTemplate.delete("http://localhost:8080/api/habitaciones/"+sku);
		Habitacion[] habitaciones = restTemplate.getForObject( "http://localhost:8080/api/habitaciones", Habitacion[].class);
		List<Habitacion> habitacionList = Optional.ofNullable(habitaciones).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("habitacion", habitacionList);
		return "habitacion";
	}
}