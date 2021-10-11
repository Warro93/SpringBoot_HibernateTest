package com.hibernate.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.dto.PersonaDto;
import com.hibernate.entity.Persona;
import com.hibernate.repository.PersonaRep;

@Service
public class PersonaServiceImp implements PersonaService{
	
	@Autowired
	PersonaRep personaRep;

	@Override
	public List<PersonaDto> getPersonaList() {
		List<Persona> listaEntity = personaRep.getPersonaList();
		List<PersonaDto> listaDto = listaEntity.stream().map(entity -> 
		new PersonaDto(entity)).collect(Collectors.toList());
		return listaDto;
	}

	@Override
	public PersonaDto insertPersona(PersonaDto personaDto) {
		Persona entity = personaRep.insertPersona(personaDto);
		PersonaDto dto = new PersonaDto(entity);
		return dto;
	}

	@Override
	public PersonaDto updatePersona(PersonaDto personaDto) {
		Persona entity = personaRep.updatePersona(personaDto);
		PersonaDto dto = new PersonaDto(entity);
		return dto;
	}

	@Override
	public PersonaDto deletePersona(PersonaDto personaDto) {
		Persona entity = personaRep.deletePersona(personaDto);
		PersonaDto dto = new PersonaDto(entity);
		return dto;
	}

	@Override
	public List<Persona> findPersonaByName(String name) {
		return personaRep.findPersonaByName(name);
	}

}
