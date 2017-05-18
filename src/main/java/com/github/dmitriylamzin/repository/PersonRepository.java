package com.github.dmitriylamzin.repository;

import com.github.dmitriylamzin.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dmitriy_Lamzin on 5/18/2017.
 */
public interface PersonRepository extends JpaRepository<Person, String> {

    Person findPersonByEmail();
}
