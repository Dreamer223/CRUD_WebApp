package ru.webapp.dreamer.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.webapp.dreamer.models.Person;


import java.util.List;
import java.util.Optional;


@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;


    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        List<Person> people;
        Session session = sessionFactory.getCurrentSession();
            people = session.createQuery("select p from Person p", Person.class).getResultList();
        return people;
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session1 = sessionFactory.getCurrentSession();
        return session1.get(Person.class, id);
    }
//    @Transactional(readOnly = true)
//    public Optional<Person> show(String email){
//        Session session = sessionFactory.getCurrentSession();
//        return Optional.ofNullable(session.get(Person.class, email));
//    }


    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }
    @Transactional
    public void update(int id, Person person) {
        Session session = sessionFactory.getCurrentSession();
        Person person1 = session.get(Person.class, id);
        person1.setName(person.getName());
        person1.setAge(person.getAge());
        person1.setEmail(person.getEmail());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        session.delete(person);
    }

//
//
//    public void testMuipleUpdate() {
//        List<Person> people = create1000People();
//
//        long before = System.currentTimeMillis();
//
//        for (Person person : people) {
//            jdbcTemplate.update("INSERT INTO person VALUES(?, ?, ?, ?)",
//                    person.getId(), person.getName(), person.getAge(), person.getEmail());
//        }
//
//        long after = System.currentTimeMillis();
//
//
//        System.out.println("Time: " + (after - before));}
//
//    private List<Person> create1000People() {
//        List<Person> people = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            people.add(new Person(i, "Name" + i, 20 + i, "email" + i + "@dreamer.com", "some address" + i));
//
//        }
//        return people;
//    }
//
//    public void testBatchUpdate() {
//        List<Person> people = create1000People();
//        long before = System.currentTimeMillis();
//        jdbcTemplate.batchUpdate("INSERT INTO person VALUES(?, ?, ?, ?)",
//                new BatchPreparedStatementSetter() {
//                    @Override
//                    public void setValues(PreparedStatement ps, int i) throws SQLException {
//                        ps.setInt(1,people.get(i).getId());
//                        ps.setString(2, people.get(i).getName());
//                        ps.setInt(3, people.get(i).getAge());
//                        ps.setString(4, people.get(i).getEmail());
//                    }
//
//                    @Override
//                    public int getBatchSize() {
//                        return 0;
//                    }
//                });
//        long after = System.currentTimeMillis();
//
//        System.out.println("Time: " + (after - before));
//    }
}
