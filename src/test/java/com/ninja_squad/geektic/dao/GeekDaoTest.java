package com.ninja_squad.geektic.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.metier.Geek;
import com.ninja_squad.geektic.metier.GeekDao;


public class GeekDaoTest extends BaseDaoTest {
	@Autowired
	private GeekDao dao;
	
	@Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(
        		Operations.deleteAllFrom("Geek"),
				Operations.insertInto("Geek")
				.columns("ID", "NOM", "PRENOM", "SEXE", "AGE", "EMAIL", "CENTREINTERETS", "GRAVATAR")
				.values( 1,"Dupont", "pierre", "H", 20, "ppierre@mail.fr", "minecraft", "")
				.values( 2,"Sba", "justine", "F", 22, "sjustine@mail.fr", "cinema", "")
				.values( 3,"Zoiur", "henri", "H", 19, "zhenri@mail.fr", "SF", "")
				.build()); // TODO define your operations here.
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }
	
	@Test
	public void testFindById()
	{
		Geek g1 = new Geek( 1,"Dupont", "pierre", "H", 20, "ppierre@mail.fr", "minecraft", "");
		
		Geek tmp = dao.findById(1);
		assertEquals(g1.getNom(), tmp.getNom());
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
		
        assertEquals(3 ,listeGeek.size());
	}
}
