package se.lexcon.data;

import se.lexcon.model.Person;

import java.util.List;

public interface PeopleImpl {
    Person cerate (Person person);

    List<Person> findAll();

    boolean findById(Boolean ID);

    List<Person> findByName(List<Person> name);

    void update (Person person);

    boolean deleteById(Boolean ID);
}
