package se.lexcon.data.Collection;

import se.lexcon.data.IdSequencer.personIdSequencer;
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
        if (person == null) throw new IllegalArgumentException("todoItem was null");
        person.setId(personIdSequencer.nextId());
        personStorage.add(person);
        return person;
    }

    public List<Person> findAll() {
        return new ArrayList<>(personStorage);
    }

    @Override
    public boolean findById(Boolean ID) {
        boolean result = findById(ID);
        return personStorage.remove(result);

    }

    public Person findById(Integer ID) {
        if(ID == null) throw new IllegalArgumentException("the id was null");
        for (Person person: personStorage) {
            if (person.getId() == (ID)) {
                return person;
            }
        }

        return null;
    }


    public List<Person> findByName(List<Person> name) {
        if(name == null) throw new IllegalArgumentException("the city code was null");
        for (Person personName: personStorage){
            if(personName.getFirst_name().equalsIgnoreCase(name.toString()))
                personStorage.add(personName);
            return personStorage;
        }
        return null;

    }

    public void update(Person person) {
        if(person == null) throw new IllegalArgumentException("city data was null");
        for(Person OriginalPerson: personStorage){
            if(OriginalPerson.getId()==person.getId()){
                OriginalPerson.setId(person.getId());
                OriginalPerson.setFirst_name(person.getFirst_name());
                OriginalPerson.setLast_name(person.getLast_name());
                OriginalPerson.setActive(person.isActive());
                OriginalPerson.setEmail(person.getEmail());
                OriginalPerson.setRegDate(person.getRegDate());
                break;
            }
        }

    }

    public boolean deleteById(Boolean ID) {
        boolean result = findById(ID);
        return personStorage.remove(result);
    }
}
