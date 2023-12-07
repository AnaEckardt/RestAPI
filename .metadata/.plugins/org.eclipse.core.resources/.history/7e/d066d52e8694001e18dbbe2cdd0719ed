package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Contato;
import com.example.demo.repository.ContatoRepository;
// o springboot transforma uma classe comum em um controller que recebe todas as requisiões.
@RestController  // passa a ser uma classe que recebe requisição.
@RequestMapping("/contatos") // se usar o requestmapping não preciso passar o end point nos métodos 
// abaixo. Mas somente posso usar se todos os métodos da classe vão usar o mesmo ednpoint contato.

public class ContatoController {
	@Autowired
	ContatoRepository repo;
		            
	    @PostMapping()
	    public ResponseEntity<Contato> InserirContatos(@RequestBody Contato contato){
	    	Contato ct = repo.save(contato);
	    	return ResponseEntity.status(HttpStatus.CREATED).body(ct);
	    }
	    
	    @PutMapping("/{idcontato}")
	    public ResponseEntity<Contato> AlterarContatos(@PathVariable("idcontato")long idcontato,@RequestBody Contato contato){
	    	Optional<Contato> opContato = repo.findById(idcontato);
	    	try {
	    		Contato ct = opContato.get();
	    		ct.setNome(contato.getNome());
	    		ct.setEmail(contato.getEmail());
	    		repo.save(ct);
	    		return ResponseEntity.status(HttpStatus.OK).body(ct);
	    		
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	   	
	    	}	    	
	    }
	    
	    @GetMapping()
	    public ResponseEntity<List<Contato>> getContatos(){
	    	return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<Contato> getUmContato(@PathVariable("id")long id) {
	    	Optional<Contato> opContato = repo.findById(id);
	    	try {
	    		Contato ct = opContato.get();
	    		return ResponseEntity.status(HttpStatus.OK).body(ct);
	    		
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
	    }
	    
	    @DeleteMapping("/{id}")
		public ResponseEntity<Contato> DeletarContato(@PathVariable("id")long id, @RequestBody Contato contato){
	    	Optional<Contato> opContato = repo.findById(id);
	    	try {
	    		Contato ct = opContato.get();
	    		repo.delete(ct);
	    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
			}	    	
		}
	}

// CAMADAS: CONTROLER >> SERVICE (REGRAS DE NEGÓCIO) >> REPOSITORY (PERSISTÊNCIA).
