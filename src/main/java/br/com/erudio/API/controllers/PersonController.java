package br.com.erudio.API.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.API.model.Person;
import br.com.erudio.API.services.PersonServices;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {
	
	@Autowired
	private PersonServices personServices;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		return ResponseEntity.ok().body(personServices.findAll());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Person> create(@RequestBody @Validated Person person){
		return ResponseEntity.ok().body(personServices.create(person));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Person>> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(personServices.findByID(id));	
}
	
}
