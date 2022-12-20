package se.lexcon.data.Collection;

import se.lexcon.data.IdSequencer.TodoItemIdSequencer;
import se.lexcon.data.TodoItemsImple;
import se.lexcon.model.Person;
import se.lexcon.model.TodoItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoitemDaoCollection implements TodoItemsImple {
    private List<TodoItem> todoItemStorage;
    private  static  TodoitemDaoCollection instance;
    private TodoitemDaoCollection() {
        todoItemStorage = new ArrayList<>();
    }
    public static TodoitemDaoCollection getInstance() {
        if (instance== null) instance = new TodoitemDaoCollection();

        return  instance;
    }

    @Override
    public TodoItem create(TodoItem todoitem) {
        if (todoitem == null) throw new IllegalArgumentException(" todoitem was null");
        todoitem.setId(TodoItemIdSequencer.nextId());
        todoItemStorage.add(todoitem);
        return todoitem;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>( todoItemStorage);
    }

    @Override
    public TodoItem findById(Integer id) {
        if (id == null) throw new IllegalArgumentException(" id is null");
        for (TodoItem itemID : todoItemStorage) {
            if (itemID.getId()==(id))
                return itemID;
        }
        return null;
    }

    @Override
    public boolean findAllByDoneStatus(boolean done) {
        for (TodoItem taskIsDone : todoItemStorage) {
            if (taskIsDone.isDone()==done) {
                taskIsDone.setDone(done);
                return true;
            }
        }
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
