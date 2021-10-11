package com.hibernate.service;

import java.util.List;

import com.hibernate.dto.PersonaDto;
import com.hibernate.entity.Persona;

public interface PersonaService {

	List<PersonaDto> getPersonaList();
	
	PersonaDto insertPersona(PersonaDto persona);
	
	PersonaDto updatePersona(PersonaDto persona);
	
	PersonaDto deletePersona(PersonaDto persona);
	
	List<Persona> findPersonaByName(String name);
}
