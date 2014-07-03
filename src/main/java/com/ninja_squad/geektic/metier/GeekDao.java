package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class GeekDao {
	@PersistenceContext
	private EntityManager em;

    public List<Geek> findAll()
    {
    	String queryAll = "select g from Geek g order by nom asc"; 
    	TypedQuery<Geek> query = em.createQuery(queryAll, Geek.class);
    	List<Geek> listeGeek = query.getResultList();
    	return listeGeek;
    }

    public Geek findById(int id) 
    {
    	return em.find(Geek.class, id);
    }
    
    public List<Geek> findByInterest(String interet)
    {
    	String queryInteret = "select g from Geek g where g.centreInterets = :interet"; 
    	TypedQuery<Geek> query = em.createQuery(queryInteret, Geek.class);
    	query.setParameter("interet", interet);
    	List<Geek> listeGeek = query.getResultList();
    	return listeGeek;
    }

    public void persist(Geek g)
    { 
		EntityTransaction tx = em.getTransaction();
    	tx.begin(); 
    	em.persist(g); 
    	tx.commit();
    }
}
