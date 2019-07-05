package pe.isil.mghplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pe.isil.mghplatform.model.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {
	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@GetMapping("/usuario")
	public String getUsuarioList(Model model){
		Usuario[] usuarios = restTemplate.getForObject( "http://localhost:8080/api/usuarios", Usuario[].class);
		List<Usuario> usuarioList = Optional.ofNullable(usuarios).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("usuario", usuarioList);
		return "usuario";
	}

	@GetMapping("/usuario/add")
	public String addUsuario(Model model){
		model.addAttribute("usuario", new Usuario());
		return "usuario-add";
	}

	@PostMapping("/usuario/save")
	public String saveUsuario(Usuario usuario, Model model){
		restTemplate.postForObject("http://localhost:8080/api/usuarios/", usuario, Usuario.class);
		Usuario[] usuarios = restTemplate.getForObject( "http://localhost:8080/api/usuarios", Usuario[].class);
		List<Usuario> usuarioList = Optional.ofNullable(usuarios).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("usuario", usuarioList);
		return "usuario";
	}

	@GetMapping("/usuario/edit/{sku}")
	public String getUsuarioForEdit(@PathVariable String sku,
										Model model){
		Usuario usuario = restTemplate.getForObject( "http://localhost:8080/api/usuarios/"+sku, Usuario.class);
		model.addAttribute("usuario",
				usuario);
		return "usuario-edit";
	}

	@PostMapping("/usuario/update/{sku}")
	public String updateUsuario(@PathVariable String sku,
									Usuario usuario,
									Model model){
		restTemplate.put("http://localhost:8080/api/usuarios/"+sku, usuario);
		Usuario[] usuarios = restTemplate.getForObject( "http://localhost:8080/api/usuarios", Usuario[].class);
		List<Usuario> usuarioList = Optional.ofNullable(usuarios).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("usuario", usuarioList);
		return "usuario";
	}

	@GetMapping("/usuario/delete/{sku}")
	public String deleteUsuario(@PathVariable String sku,
									Model model){
		restTemplate.delete("http://localhost:8080/api/usuarios/"+sku);
		Usuario[] usuarios = restTemplate.getForObject( "http://localhost:8080/api/usuarios", Usuario[].class);
		List<Usuario> usuarioList = Optional.ofNullable(usuarios).map(Arrays::asList).orElseGet(ArrayList::new);
		model.addAttribute("usuario", usuarioList);
		return "usuario";
	}
}