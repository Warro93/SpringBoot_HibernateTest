package com.hibernate.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Corso implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_corso")
	private Long id;
	private String nome;
	private Integer numeroIscritti;
	
	//@JsonIgnore
	@ManyToMany
	@JoinTable(	
			name = "persone_corsi",
			joinColumns = @JoinColumn (name = "id_corso"),
			inverseJoinColumns = @JoinColumn (name = "id_persona")
	)
	private Set<Persona> listaPersone;
	
	public Corso() {

	}
	
	public Set<Persona> getListaPersone() {
		return listaPersone;
	}

	public void setListaPersone(Set<Persona> listaPersone) {
		this.listaPersone = listaPersone;
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
	public Integer getNumeroIscritti() {
		return numeroIscritti;
	}
	public void setNumeroIscritti(Integer numeroIscritti) {
		this.numeroIscritti = numeroIscritti;
	}
	
	
	
}
