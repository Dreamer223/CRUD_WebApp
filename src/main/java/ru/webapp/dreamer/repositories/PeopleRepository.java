package ru.webapp.dreamer.repositories;


import org.springframework.stereotype.Repository;
import ru.webapp.dreamer.models.Person;

import java.lang.annotation.Annotation;

@Repository
public class PeopleRepository extends Repository<Person, Integer> {

}
