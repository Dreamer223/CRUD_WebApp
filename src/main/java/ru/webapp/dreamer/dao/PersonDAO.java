package ru.webapp.dreamer.dao;

import org.springframework.stereotype.Component;
import ru.webapp.dreamer.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people =new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Ivan", 30, "Ivan@example.com"));
        people.add(new Person(++PEOPLE_COUNT, "Petr", 40, "Petr@example.com"));
        people.add(new Person(++PEOPLE_COUNT, "Sidor", 50, "Sidor@example.com"));
        people.add(new Person(++PEOPLE_COUNT, "Alex", 25, "Alex@example.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
