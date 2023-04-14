package br.com.erudio.API.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.API.model.Person;

public interface PersonRepository  extends JpaRepository<Person, Long>{

}
