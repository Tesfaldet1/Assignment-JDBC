package se.lexcon.data.Collection;

import se.lexcon.data.PeopleImpl;
import se.lexcon.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoCollection implements PeopleImpl {

    private List<Person> personStorage;
    private static  PersonDaoCollection instance;
    private PersonDaoCollection() {
        personStorage = new ArrayList<>();
    }

    public static  PersonDaoCollection getInstance() {
        if (instance== null) instance = new PersonDaoCollection();
        return  instance;
    }

    @Override
    public Person cerate(Person person) {
        return null;
    }

    public List<Person> findAll() {
        return null;
    }

    public Person findById(Integer ID) {
        return null;
    }

    public List<Person> findByName(List<Person> name) {
        return null;
    }

    public void update(Person person) {

    }

    public boolean deleteById(Boolean ID) {
        return false;
    }
}
