package com.github.dmitriylamzin;


import com.github.dmitriylamzin.domain.Person;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collections;

/**
 * Created by Dmitriy_Lamzin on 5/15/2017.
 */
public class MyTest {

    @Test
    public void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Person person = new Person("email@email.ru");
        person.setFirstname("first");
        person.setLastname("last");
        person.setPassword("password");
        Groups groups = new Groups();
        groups.setName("newGroup");
        person.setGroupsList(Collections.singletonList(groups));
        groups.setPersonList(Collections.singletonList(person));
        em.persist(person);
        em.flush();

        transaction.commit();

    }

}
