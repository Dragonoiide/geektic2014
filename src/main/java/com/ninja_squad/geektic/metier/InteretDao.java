package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class InteretDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Interet> findAll()
    {
    	String queryAll = "select i from Interet i order by i.nomInteret asc"; 
    	TypedQuery<Interet> query = em.createQuery(queryAll, Interet.class);
    	List<Interet> listeInteret = query.getResultList();
    	return listeInteret;
    }

}
