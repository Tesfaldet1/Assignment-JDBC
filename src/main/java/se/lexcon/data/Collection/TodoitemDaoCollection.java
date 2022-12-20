package se.lexcon.data.Collection;

import se.lexcon.data.TodoItemsImple;
import se.lexcon.model.Person;
import se.lexcon.model.TodoItem;

import java.util.Collection;

public class TodoitemDaoCollection implements TodoItemsImple {

    @Override
    public TodoItem create(TodoItem todoitem) {
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return null;
    }

    @Override
    public TodoItem findById(Integer id) {
        return null;
    }

    @Override
    public boolean findAllByDoneStatus(boolean done) {
        return false;
    }

    @Override
    public Collection<TodoItem> findByAssigee(int todo) {
        return null;
    }

    @Override
    public Collection<Person> findbyAssigee(Person person) {
        return null;
    }

    @Override
    public TodoItem findByUnassignedTodoItem() {
        return null;
    }

    @Override
    public void update(TodoItem toupdate) {

    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }
}
