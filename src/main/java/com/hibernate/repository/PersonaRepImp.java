package com.hibernate.repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hibernate.dto.PersonaDto;
import com.hibernate.entity.Persona;

@Repository
public class PersonaRepImp implements PersonaRep{
	
	@PersistenceContext
	private EntityManager entityManager;	//Per interrogare il database

	// Chiamata Get / Read
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> getPersonaList() {
		Query q = entityManager.createQuery("SELECT u FROM Persona u");
		return q.getResultList();
	}

	// Chiamata Post / Insert
	@Override
	@Transactional
	public Persona insertPersona(PersonaDto personaDto) {
		Persona entity = new Persona(personaDto);
		entityManager.persist(entity);
		return entity;
	}

	// Chiamata Put / Update
	@Override
	@Transactional
	public Persona updatePersona(PersonaDto personaDto) {
		Persona entity = new Persona(personaDto);
		return entityManager.merge(entity);
	}

	// Chiamata Delete
	@Override
	@Transactional
	public Persona deletePersona(PersonaDto personaDto) {
		
		Persona p = entityManager.find(Persona.class, personaDto.getId());
		entityManager.remove(p);
		
		Persona entity = new Persona(personaDto);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> findPersonaByName(String nome) {
		Query q = entityManager.createQuery("SELECT u FROM Persona u WHERE u.nome= :nome");
		q.setParameter("nome", nome);
		return q.getResultList();
	}

}
