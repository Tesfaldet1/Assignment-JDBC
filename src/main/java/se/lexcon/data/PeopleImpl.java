package se.lexcon.data;

import se.lexcon.data.Collection.PersonDaoCollection;
import se.lexcon.model.Person;

import java.util.List;

public interface PeopleImpl {
    Person cerate (Person person);

    List<Person> findAll();

    Person findById(Integer ID);

    List<Person> findByName(List<Person> name);

    void update (Person person);

    boolean deleteById(Boolean ID);
}
