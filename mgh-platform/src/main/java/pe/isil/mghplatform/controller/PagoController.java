package pe.isil.mghplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pe.isil.mghplatform.model.Pago;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PagoController {
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

	@GetMapping("/pago")
	public String getPagoList(Model model){
		Pago[] pagos = restTemplate.getForObject( "http://localhost:8080/api/pagos", Pago[].class);
		List<Pago> pagoList = Optional.ofNullable(pagos).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("pago", pagoList);
		return "pago";
	}

	@GetMapping("/pago/add")
	public String addPago(Model model){
		model.addAttribute("pago", new Pago());
		return "pago-add";
	}

	@PostMapping("/pago/save")
	public String savePago(Pago pago, Model model){
		restTemplate.postForObject("http://localhost:8080/api/pagos/", pago, Pago.class);
		Pago[] pagos = restTemplate.getForObject( "http://localhost:8080/api/pagos", Pago[].class);
		List<Pago> pagoList = Optional.ofNullable(pagos).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("pago", pagoList);
		return "pago";
	}

	@GetMapping("/pago/edit/{sku}")
	public String getPagoForEdit(@PathVariable String sku,
										Model model){
		Pago pago = restTemplate.getForObject( "http://localhost:8080/api/pagos/"+sku, Pago.class);
		model.addAttribute("pago",
				pago);
		return "pago-edit";
	}

	@PostMapping("/pago/update/{sku}")
	public String updatePago(@PathVariable String sku,
									Pago pago,
									Model model){
		restTemplate.put("http://localhost:8080/api/pagos/"+sku, pago);
		Pago[] pagos = restTemplate.getForObject( "http://localhost:8080/api/pagos", Pago[].class);
		List<Pago> pagoList = Optional.ofNullable(pagos).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("pago", pagoList);
		return "pago";
	}

	@GetMapping("/pago/delete/{sku}")
	public String deletePago(@PathVariable String sku,
									Model model){
		restTemplate.delete("http://localhost:8080/api/pagos/"+sku);
		Pago[] pagos = restTemplate.getForObject( "http://localhost:8080/api/pagos", Pago[].class);
		List<Pago> pagoList = Optional.ofNullable(pagos).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("pago", pagoList);
		return "pago";
	}
}