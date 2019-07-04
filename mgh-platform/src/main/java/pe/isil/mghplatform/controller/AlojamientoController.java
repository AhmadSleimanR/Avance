package pe.isil.mghplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pe.isil.mghplatform.model.Alojamiento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AlojamientoController {
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

	@GetMapping("/alojamiento")
	public String getAlojamientoList(Model model){
		Alojamiento[] alojamientos = restTemplate.getForObject( "http://localhost:8080/api/alojamientos", Alojamiento[].class);
		List<Alojamiento> alojamientoList = Optional.ofNullable(alojamientos).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("alojamiento", alojamientoList);
		return "alojamiento";
	}

	@GetMapping("/alojamiento/add")
	public String addAlojamiento(Model model){
		model.addAttribute("alojamiento", new Alojamiento());
		return "alojamiento-add";
	}

	@PostMapping("/alojamiento/save")
	public String saveAlojamiento(Alojamiento alojamiento, Model model){
		restTemplate.postForObject("http://localhost:8080/api/alojamientos/", alojamiento, Alojamiento.class);
		Alojamiento[] alojamientos = restTemplate.getForObject( "http://localhost:8080/api/alojamientos", Alojamiento[].class);
		List<Alojamiento> alojamientoList = Optional.ofNullable(alojamientos).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("alojamiento", alojamientoList);
		return "alojamiento";
	}

	@GetMapping("/alojamiento/edit/{sku}")
	public String getAlojamientoForEdit(@PathVariable String sku,
									Model model){
		Alojamiento alojamiento = restTemplate.getForObject( "http://localhost:8080/api/alojamientos/"+sku, Alojamiento.class);
		model.addAttribute("alojamiento",
				alojamiento);
		return "alojamiento-edit";
	}

	@PostMapping("/alojamiento/update/{sku}")
	public String updateAlojamiento(@PathVariable String sku,
								Alojamiento alojamiento,
								Model model){
		restTemplate.put("http://localhost:8080/api/alojamientos/"+sku, alojamiento);
		Alojamiento[] alojamientos = restTemplate.getForObject( "http://localhost:8080/api/alojamientos", Alojamiento[].class);
		List<Alojamiento> alojamientoList = Optional.ofNullable(alojamientos).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("alojamiento", alojamientoList);
		return "alojamiento";
	}

	@GetMapping("/alojamiento/delete/{sku}")
	public String deleteAlojamiento(@PathVariable String sku,
								Model model){
		restTemplate.delete("http://localhost:8080/api/alojamientos/"+sku);
		Alojamiento[] alojamientos = restTemplate.getForObject( "http://localhost:8080/api/alojamientos", Alojamiento[].class);
		List<Alojamiento> alojamientoList = Optional.ofNullable(alojamientos).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("alojamiento", alojamientoList);
		return "alojamiento";
	}
}
