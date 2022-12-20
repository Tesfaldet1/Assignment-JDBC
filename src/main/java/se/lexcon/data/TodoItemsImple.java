package se.lexcon.data;

import se.lexcon.model.Person;
import se.lexcon.model.TodoItem;

import java.util.Collection;

public interface TodoItemsImple {
    TodoItem create (TodoItem todoitem);

    Collection<TodoItem> findAll ();

    TodoItem findById(Integer id);


    boolean findAllByDoneStatus(boolean done);


    Collection<TodoItem> findByAssigee (int todo);

    Collection<Person> findbyAssigee (Person person);

    TodoItem findByUnassignedTodoItem();

    void update(TodoItem toupdate);

    boolean remove (Integer id);

}
