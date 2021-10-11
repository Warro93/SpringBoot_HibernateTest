package com.hibernate.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.dto.PersonaDto;
import com.hibernate.entity.Persona;
import com.hibernate.service.PersonaService;

@RestController
@RequestMapping("/")
public class PersonaController {
	
	@Autowired
	private Environment environment;	//Per leggere l'application properties

	@Autowired
	private PersonaService personaService;	//Creare istanza della classe PersonaService
	
	@GetMapping("/persone")
	public ResponseEntity<List<PersonaDto>> getPersonaList(){
		System.out.println(environment.getProperty("titolo"));
		List<PersonaDto> listaPersone = personaService.getPersonaList();
		return new ResponseEntity<List<PersonaDto>>
								(listaPersone, HttpStatus.OK);
	}
	
	@PostMapping("/persone")
	public ResponseEntity<PersonaDto> insertPersona
	(@RequestBody @Valid PersonaDto personaDto, BindingResult result){
		
		if(result.hasErrors()) {
			System.out.println("Errore nell'inserimento dei dati.");
			return null;
		}
		else {
			PersonaDto pCattura = personaService.insertPersona(personaDto);
			return new ResponseEntity<PersonaDto>(pCattura, HttpStatus.CREATED);
		}
	}
	
	@PutMapping("/persone")
	public ResponseEntity<PersonaDto> updatePersona
	(@RequestBody @Valid PersonaDto personaDto, BindingResult result){
		
		if(result.hasErrors()) {
			System.out.println("Errore nell'inserimento dei dati.");
			return null;
		}
		else {
			PersonaDto pCattura = personaService.updatePersona(personaDto);
			return new ResponseEntity<PersonaDto>(pCattura, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/persone")
	public ResponseEntity<PersonaDto> deletePersona
	(@RequestBody @Valid PersonaDto personaDto, BindingResult result){
		
		if(result.hasErrors()) {
			System.out.println("Errore nell'inserimento dei dati.");
			return null;
		}
		else {
			PersonaDto pCattura = personaService.deletePersona(personaDto);
			return new ResponseEntity<PersonaDto>(pCattura, HttpStatus.OK);
		}
	}
	
	@GetMapping("/persone/{name}")
	public ResponseEntity<List<Persona>> findPersonaByName(@PathVariable String name){
		List<Persona> listaPersone = personaService.findPersonaByName(name);
		return new ResponseEntity<List<Persona>>
								(listaPersone, HttpStatus.OK);
	}
}
