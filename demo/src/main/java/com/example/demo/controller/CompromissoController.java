package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Compromisso;
import com.example.demo.repository.CompromissoRepository;

@RestController
@RequestMapping

public class CompromissoController {
	@Autowired
	CompromissoRepository repo;
	
	
	@PostMapping()
	public ResponseEntity<Compromisso> InserirCompromisso(@RequestBody Compromisso compromisso) {
		Compromisso comp = repo.save(compromisso);
		return ResponseEntity.status(HttpStatus.CREATED).body(comp);
	}
	
	//@PutMapping("/{idcomp}")
	//public ResponseEntity<Compromisso> AlterarCompromisso(@PathVariable("idcomp") long idcomp, @RequestBody Compromisso compromisso) {
		//Optional<Compromisso> opComp = repo.findById(idcomp);
		//try {
			//Compromisso comp = opComp.get();
			//comp.setNome(loca1.getNome());
			//lc1.setRua(loca1.getRua());
			//lc1.setBairro(loca1.getBairro());
			//lc1.setCidade(loca1.getCidade());
			//lc1.setCep(loca1.getCep());
			//repo.save(lc1);
			//return ResponseEntity.status(HttpStatus.OK).body(lc1);

		//} catch (Exception e) {
		//	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		//}
	}
	


