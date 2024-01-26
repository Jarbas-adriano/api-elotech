package com.debitos.apidebitos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debitos.apidebitos.models.Debito;
import com.debitos.apidebitos.repository.DebitoRepository;

@RestController
@RequestMapping(value = "/api")
public class DebitoResource {

	@Autowired
	DebitoRepository debitoRepository;
	
	@GetMapping("/debitos")
	public List<Debito> listaDebitos() {
		return debitoRepository.findAll();
	}
	
	@GetMapping("/debitos/{id}")
	public Debito listaDebitosById(@PathVariable(value = "id") long id ) {
		return debitoRepository.findById(id);
	}
	
	@PostMapping("/debitos")
	public Debito saveDebito(@RequestBody Debito debito) {
		return debitoRepository.save(debito);
	}
}