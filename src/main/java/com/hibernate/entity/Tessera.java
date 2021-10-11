package com.hibernate.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//Serializzazione = serve a trasformare una classe in uno stream di dati 
//per poter viaggiare in un flusso / in rete
@Entity
public class Tessera implements Serializable{

	private static final long serialVersionUID = 1L;	//Riferimento che serve ad Hibernate
												//per quando andrà a deserializzare la classe
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String attivita;
	private String promozione;
	
	public Tessera() {
		
	}

	public Long getId() {
		return id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttivita() {
		return attivita;
	}

	public void setAttivita(String attivita) {
		this.attivita = attivita;
	}

	public String getPromozione() {
		return promozione;
	}

	public void setPromozione(String promozione) {
		this.promozione = promozione;
	}
	
}
