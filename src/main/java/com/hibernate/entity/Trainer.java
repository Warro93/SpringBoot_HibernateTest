package com.hibernate.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_trainer")
	private Long id;
	private String nome;
	private String cognome;
	
	@OneToMany(mappedBy = "trainer")
	private Set<Persona> listaAllievi;
	
	public Trainer() {
		
	}

	public Set<Persona> getListaAllievi() {
		return listaAllievi;
	}

	public void setListaAllievi(Set<Persona> listaAllievi) {
		this.listaAllievi = listaAllievi;
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

	
}
