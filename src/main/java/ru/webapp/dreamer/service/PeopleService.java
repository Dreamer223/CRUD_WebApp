package ru.webapp.dreamer.service;


import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.webapp.dreamer.models.Person;
import ru.webapp.dreamer.repositories.ItemsRepository;
import ru.webapp.dreamer.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;
    private final ItemsRepository itemsRepository;

    public PeopleService(PeopleRepository peopleRepository, ItemsRepository itemsRepository) {
        this.peopleRepository = peopleRepository;
        this.itemsRepository = itemsRepository;
    }
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @Transactional
    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        Person person = foundPerson.orElse(null);

        if (person == null) {
            return null;
        }
        person.setItem(itemsRepository.findByOwner(person));
        return person;
    }


    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }


    @Transactional
    public void updatePerson(int id,Person person) {
        person.setId(id);
        peopleRepository.save(person);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}
