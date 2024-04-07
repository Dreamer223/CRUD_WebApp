package ru.webapp.dreamer.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webapp.dreamer.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    Person findByEmail(String email);


    List<Person> findByName(String name);

    List<Person> findByNameOrderByAge(String name);

    List<Person> findByNameStartsWith(String startWith);

    List<Person> findByNameOrEmail(String name, String email);

}
