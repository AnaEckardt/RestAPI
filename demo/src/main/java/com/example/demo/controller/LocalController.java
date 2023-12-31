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

import com.example.demo.entidades.Locais;
import com.example.demo.repository.LocalRepository;

@RestController
@RequestMapping("/locais")
public class LocalController {
	@Autowired
	LocalRepository repo;

	/*@PostMapping
	public ResponseEntity<Locais> InserirLocal(@RequestBody Locais local) {
		Locais lc = repo.save(local);
		return ResponseEntity.status(HttpStatus.CREATED).body(lc);
	}
*/
	@PutMapping("/{idlocal}")
	public ResponseEntity<Locais> AlterarLocal(@PathVariable("idlocal") long idlocal, @RequestBody Locais loca1) {
		Optional<Locais> opLocal = repo.findById(idlocal);
		try {
			Locais lc1 = opLocal.get();
			lc1.setNome(loca1.getNome());
			lc1.setRua(loca1.getRua());
			lc1.setBairro(loca1.getBairro());
			lc1.setCidade(loca1.getCidade());
			lc1.setCep(loca1.getCep());
			repo.save(lc1);
			return ResponseEntity.status(HttpStatus.OK).body(lc1);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping()
	public ResponseEntity<List<Locais>> BuscarLocal(){
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Locais> BuscarUmLocal(@PathVariable ("id") long id){
		Optional<Locais> opLocal = repo.findById(id);
		try {
			Locais lcl = opLocal.get();
			return ResponseEntity.status(HttpStatus.OK).body(lcl);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}			
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Locais> DeletarLocal(@PathVariable("id") long id,@RequestBody Locais local) {
		Optional<Locais> opLocal = repo.findById(id);
		try {
			Locais lcl = opLocal.get();
			repo.delete(lcl);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return null;		
	}

}
