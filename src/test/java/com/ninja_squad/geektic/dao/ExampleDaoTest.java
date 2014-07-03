package com.ninja_squad.geektic.dao;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;

import org.junit.Before;
import org.junit.Test;


/**
 * This is example code for a DAO test.
 * @author JB Nizet
 */
public class ExampleDaoTest extends BaseDaoTest {

    // You can autowire the DAO to test here. For example:
    // @Autowired
    // private ExampleDao exampleDao;

    @Before
    public static void populateDatabase() {
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
    public void testSomeDaoMethod() {
        // implement your test here, by calling the exampleDao method to test.
    }
    
}
