package com.github.dmitriylamzin;

import com.github.dmitriylamzin.repository.PersonRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by Dmitriy on 08.05.2017.
 */
@Stateless
public class SimpleMarket {

    @Inject
    private PersonRepository personRepository;

    public SimpleMarket() {
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
