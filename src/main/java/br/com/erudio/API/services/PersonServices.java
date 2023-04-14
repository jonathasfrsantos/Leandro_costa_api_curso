package br.com.erudio.API.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.API.model.Person;
import br.com.erudio.API.repositories.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll(){
		return personRepository.findAll();
	}
	
	public Person create(Person person) {
		return person;
	}
	
	public Optional<Person> findByID(Long id ) {
		return personRepository.findById(id);
	}
	
	public Person update(Person person, Long id) {
		Person newPerson = new Person();
		
		if(personRepository.findById(id) != null) {
		
			newPerson.setFirstName(person.getFirstName());
			newPerson.setLastName(person.getLastName());
			newPerson.setGender(person.getGender());
			newPerson.setAdress(person.getAdress());
			
			
		}
		
		return newPerson;
	}
	

}
