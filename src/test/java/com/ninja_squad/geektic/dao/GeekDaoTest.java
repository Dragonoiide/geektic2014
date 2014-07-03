package com.ninja_squad.geektic.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.aspectj.lang.annotation.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import aj.org.objectweb.asm.Type;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.geektic.metier.Geek;
import com.ninja_squad.geektic.metier.GeekDao;


public class GeekDaoTest {
	private static EntityManagerFactory emFactory;
	private EntityManager em;
	private GeekDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emFactory = Persistence.createEntityManagerFactory("Geektic");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		emFactory.close();
	}

	@Before
	public void setUp() throws Exception {
		em = emFactory.createEntityManager();
		dao = new GeekDao(em);
		ExampleDaoTest.populateDatabase();
		em.getTransaction().begin();
	}
	
	@Test
	public void testFindById()
	{
		GeekDao sd = new GeekDao(em);
		Geek g1 = new Geek( 1,"Dupont", "pierre", "H", 20, "ppierre@mail.fr", "minecraft", "");
		
		Geek tmp = sd.findById(1);
		assertEquals(tmp, g1);
	}
	
	@Test
	public void testPersist()
	{
		Geek s = new Geek( 4,"Test", "test", "H", 20, "test@mail.fr", "test", "");
		em.persist(s);
	}
	
	@Test
	public void testAll()
	{
		List<Geek> listeGeek = null;
		listeGeek = dao.findAll();
		
		Geek temp = new Geek( 3,"Zoiur", "henri", "H", 19, "zhenri@mail.fr", "SF", "");
        assertTrue(listeGeek.contains(temp));
	}
	
	@After(value = "")
	public void tearDown() throws Exception {
		em.getTransaction().commit();
		em.close();
	}
}
