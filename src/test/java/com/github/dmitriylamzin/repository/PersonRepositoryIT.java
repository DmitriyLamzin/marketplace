package com.github.dmitriylamzin.repository;

import com.github.dmitriylamzin.SimpleMarket;
import com.github.dmitriylamzin.domain.Person;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Dmitriy_Lamzin on 5/18/2017.
 */
public class PersonRepositoryIT {

    @Test
    public void shouldCreateABook() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));
        try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
            Context ctx = ec.getContext();
// Check JNDI dependencies (Datasource and EJBs)
            assertNotNull(ctx.lookup("java:global/jdbc/testDS"));
            assertNotNull(
                    ctx.lookup("java:global/classes/SimpleMarket!com.github.dmitriylamzin.SimpleMarket"));
            assertNotNull(
                    ctx.lookup("java:global/classes/SimpleMarket!com.github.dmitriylamzin.SimpleMarket"));
// Looks up the EJB
            SimpleMarket simpleMarket = (SimpleMarket)
            ctx.lookup("java:global/classes/SimpleMarket!com.github.dmitriylamzin.SimpleMarket");
// Finds all the books and makes sure there are two (inserted by the DBPopulator)
            PersonRepository personRepository = simpleMarket.getPersonRepository();

            List<Person> personList = personRepository.findAll();
            System.out.println(personList);
        }
    }
}
