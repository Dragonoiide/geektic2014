package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class GeekDao {
	@PersistenceContext
	private EntityManager em;

    public List<Geek> findAll()
    {
    	String queryAll = "select g from Geek g order by g.nom asc"; 
    	TypedQuery<Geek> query = em.createQuery(queryAll, Geek.class);
    	List<Geek> listeGeek = query.getResultList();
    	return listeGeek;
    }
    
    public int countGeek()
    {
    	String queryCount = "select count(g) from Geek g";
    	Query query = em.createQuery(queryCount);
    	int numGeek =((Number) query.getSingleResult()).intValue();
    	return numGeek;
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
    
    public List<Geek> research(String sexe, String interet)
    {
    	String jpql = "select g from Geek as g"
                + " join g.interet i"
                + " where g.sexe = :sexe and i.nom = :interet";
        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
        query.setParameter("sexe", sexe);
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
