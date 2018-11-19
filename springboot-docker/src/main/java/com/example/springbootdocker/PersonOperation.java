package com.example.springbootdocker;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController 
public class PersonOperation {
	
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping("/person")
	public List<Person> getAllPerson(){
		return personRepository.findAll();
	}

	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable long id) {
		Optional<Person> person= personRepository.findById(id);
		if(!person.isPresent())
			throw new PersonNotFoundException("id-"+id);
		return person.get();
	}
	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable long id) {
		personRepository.deleteById(id);
	}
	@PostMapping("/person/{id}")
	public ResponseEntity<Object>createPerson(@RequestBody Person person){
		Person savePerson=personRepository.save(person);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savePerson.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	@PutMapping("/person/{id}")
	public ResponseEntity<Object> updatePerson(@RequestBody Person person,@PathVariable long id){
		Optional<Person> findPerson=personRepository.findById(id);
		
		if(!findPerson.isPresent())
			return ResponseEntity.notFound().build();
		
		person.setId(id);
	    personRepository.save(person);
	    return ResponseEntity.noContent().build();
	}
	
}
