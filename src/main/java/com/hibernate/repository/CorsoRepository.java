package com.hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.hibernate.entity.Corso;

@Repository
public class CorsoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Corso> getCorsiList(){
		Query q = entityManager.createQuery("SELECT u FROM Corso u");
		return q.getResultList();
	}
}
