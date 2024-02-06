package com.debitos.apidebitos.resources;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debitos.apidebitos.models.Debito;
import com.debitos.apidebitos.models.DebitoParcela;
import com.debitos.apidebitos.repository.DebitoParcelaRepository;
import com.debitos.apidebitos.repository.DebitoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class DebitoResource {

	@Autowired
	DebitoRepository debitoRepository;
	
	@Autowired
	DebitoParcelaRepository debitoParcelaRepository;
	
	@GetMapping("/debitos")
	public List<Debito> listaDebitos() {
		return debitoRepository.findAll();
	}

	@GetMapping("/debitos/{id}")
	public Debito listaDebitosById(@PathVariable(value = "id") long id) {
		return debitoRepository.findById(id);
	}
	
	@GetMapping("/debitos/sumValues")
	public Double SumValues() {
		 return debitoRepository.sumValues();
	}

	@PostMapping("/debitos")
	public String saveDebito(@Valid @RequestBody Debito debito) {

		try {

			//System.out.println("Debito: " + debito.toString());

			for (DebitoParcela parcela : debito.getParcela()) {
				parcela.setDebito(debito);
			}

			debito.setParcela(debito.getParcela());

			// System.out.println("Debito: "+debito.getParcela());

			debitoRepository.save(debito);

			return "OK";

		} catch (JDBCException e) {
			return "Erro: " + e;

		}
	}
	
	@DeleteMapping("/debitos")
	public void DeletaDebitos(@Valid @RequestBody Debito debito) {
		 debitoRepository.delete(debito);
	}
	
	@DeleteMapping("/debitos/{id}")
	public void DeletaDebitosById(@PathVariable(value = "id") long id) {
		 debitoRepository.deleteById(id);
	}
	
	@PutMapping("/debitos")
	public String AtualizaDebitos(@Valid @RequestBody Debito debito) {
		
		try {

			//System.out.println("Debito: " + debito.toString());

			for (DebitoParcela parcela : debito.getParcela()) {
				parcela.setDebito(debito);
			}

			debito.setParcela(debito.getParcela());

			// System.out.println("Debito: "+debito.getParcela());

			debitoRepository.save(debito);

			return "OK";

		} catch (HibernateException e) {
			return "Erro: " + e;

		}
	}
	

}
