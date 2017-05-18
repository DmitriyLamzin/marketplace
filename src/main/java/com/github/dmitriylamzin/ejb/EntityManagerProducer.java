package com.github.dmitriylamzin.ejb;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Dmitriy_Lamzin on 5/18/2017.
 */
public class EntityManagerProducer {
    @Produces
    @Dependent
    @PersistenceContext
    public EntityManager entityManager;
}
