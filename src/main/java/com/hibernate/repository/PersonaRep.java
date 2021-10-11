package com.hibernate.repository;

import java.util.List;

import com.hibernate.dto.PersonaDto;
import com.hibernate.entity.Persona;

public interface PersonaRep {

	List<Persona> getPersonaList();
	
	Persona insertPersona(PersonaDto persona);
	
	Persona updatePersona(PersonaDto persona);
	
	Persona deletePersona(PersonaDto persona);
	
	List<Persona> findPersonaByName(String name);
}
