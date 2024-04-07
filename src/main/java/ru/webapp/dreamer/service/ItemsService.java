package ru.webapp.dreamer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.webapp.dreamer.models.Item;
import ru.webapp.dreamer.models.Person;
import ru.webapp.dreamer.repositories.ItemsRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemsService {

    private final ItemsRepository itemsRepository;


    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> findByName(String name) {
        return itemsRepository.findByName(name);
    }

    public List<Item> findByOwner(Person owner) {
        return itemsRepository.findByOwner(owner);
    }
























}
