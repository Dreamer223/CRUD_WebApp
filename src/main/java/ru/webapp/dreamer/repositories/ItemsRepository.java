package ru.webapp.dreamer.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.webapp.dreamer.models.Item;
import ru.webapp.dreamer.models.Person;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    List<Item> findByName(String item_name);

    List<Item> findByOwner(Person owner);
}
