package com.hibernate.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hibernate.dto.PersonaDto;

@Entity
@Table(name = "iscritti")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_persona")
	private Long id;
	
	@Size(min=3, max=16)
	// @Column(length = 16) //altra annotazione per fare controlli
	private String nome;
	
	@Size(min=3, max=16)
	private String cognome;
	
	@Min(value = 18) @Max(value = 99)
	@Transient
	private Integer eta;
	
	@CreationTimestamp
	private Timestamp dataCreazione;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn()
	private Tessera tesseraIscrizione;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="id_trainer")
	private Trainer trainer;
	
	//@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(	
				name = "persone_corsi",
				joinColumns = @JoinColumn (name = "id_persona"),
				inverseJoinColumns = @JoinColumn (name = "id_corso")
	)
	private Set<Corso> listaCorsi;
	
	
	public Persona() {
		
	}
	
	public Persona(PersonaDto personaDto) {
		this.nome = personaDto.getNome();
		this.cognome = personaDto.getCognome();
		this.eta = personaDto.getEta();
		this.id = personaDto.getId();
		this.tesseraIscrizione = new Tessera();
		tesseraIscrizione.setAttivita(personaDto.getTesseraIscrizione().getAttivita());
		tesseraIscrizione.setPromozione(personaDto.getTesseraIscrizione().getPromozione());
		tesseraIscrizione.setId(personaDto.getTesseraIscrizione().getId());
		this.trainer = new Trainer();
		trainer.setNome(personaDto.getTrainer().getNome());
		trainer.setCognome(personaDto.getTrainer().getCognome());
		trainer.setId(personaDto.getTrainer().getId());
		this.listaCorsi = new HashSet<>();
		this.listaCorsi = personaDto.getListaCorsi();
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

	public void setTesseraIscrizione(Tessera tesseraIscrizione) {
		this.tesseraIscrizione = tesseraIscrizione;
	}
	
	public Tessera getTesseraIscrizione() {
		return tesseraIscrizione;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Timestamp getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Timestamp dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(id, other.id);
	}

	
}
