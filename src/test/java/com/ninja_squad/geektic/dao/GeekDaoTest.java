package com.ninja_squad.geektic.dao;

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
		Spectacle s1 = new Spectacle("Dernier coup de ciseaux",Type.THEATRE,"Troupe des Mathurins");
		
		Spectacle tmp = sd.findById((new Long(1)));
		assertEquals(tmp, s1);
	}
	
	@Test
	public void testPersist()
	{
		Spectacle s = new Spectacle("No name", Type.CONCERT, "No name");
		em.persist(s);
	}
	
	@Test
	public void testAll()
	{
		List<Spectacle> listeSpec = null;
		listeSpec = dao.findAll();
		
		Spectacle temp = new Spectacle("Dernier coup de ciseaux", Type.THEATRE, "Troupe des Mathurins");
        assertTrue(listeSpec.contains(temp));
	}
	
	@After
	public void tearDown() throws Exception {
		em.getTransaction().commit();
		em.close();
	}
}
