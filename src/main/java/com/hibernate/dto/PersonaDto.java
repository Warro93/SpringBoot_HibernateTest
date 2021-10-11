package com.hibernate.dto;


import java.util.HashSet;
import java.util.Set;

import com.hibernate.entity.Corso;
import com.hibernate.entity.Persona;
import com.hibernate.entity.Tessera;
import com.hibernate.entity.Trainer;

public class PersonaDto {

	private Long id;
	private String nome;
	private String cognome;
	private Integer eta;
	
	private Tessera tesseraIscrizione;
	
	private Trainer trainer;
	
	private Set<Corso> listaCorsi;
	
	
	public PersonaDto() {
		
	}
	
	public PersonaDto(Persona persona) {
		this.nome = persona.getNome();
		this.cognome = persona.getCognome();
		this.eta = persona.getEta();
		this.tesseraIscrizione = new Tessera();
		tesseraIscrizione.setAttivita(persona.getTesseraIscrizione().getAttivita());
		tesseraIscrizione.setPromozione(persona.getTesseraIscrizione().getPromozione());
		tesseraIscrizione.setId(persona.getTesseraIscrizione().getId());
		this.trainer = new Trainer();
		trainer.setNome(persona.getTrainer().getNome());
		trainer.setCognome(persona.getTrainer().getCognome());
		trainer.setId(persona.getTrainer().getId());
		this.listaCorsi = new HashSet<>();
		this.listaCorsi = persona.getListaCorsi();
	}
	
	public Set<Corso> getListaCorsi() {
		return listaCorsi;
	}

	public void setListaCorsi(Set<Corso> listaCorsi) {
		this.listaCorsi = listaCorsi;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	public Tessera getTesseraIscrizione() {
		return tesseraIscrizione;
	}

	public void setTesseraIscrizione(Tessera tesseraIscrizione) {
		this.tesseraIscrizione = tesseraIscrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	
}

