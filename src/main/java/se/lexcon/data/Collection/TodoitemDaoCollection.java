package se.lexcon.data.Collection;

import se.lexcon.data.IdSequencer.TodoItemIdSequencer;
import se.lexcon.data.PeopleImpl;
import se.lexcon.data.TodoItemsImple;
import se.lexcon.model.TodoItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class TodoitemDaoCollection implements TodoItemsImple {
    private List<TodoItem> todoItemStorage;
    private  static  TodoitemDaoCollection instance;
    private TodoitemDaoCollection() {
        todoItemStorage = new ArrayList<>();
    }
    PeopleImpl personStorage= PersonDaoCollection.getInstance();
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
    public Optional<TodoItem> findByAssignee(TodoItem person) {
        for(TodoItem personStatus: todoItemStorage){
            if(personStatus.getAssignee().equals(person)){
                return Optional.of(personStatus);
            }
        }
        return null;
    }

    @Override
    public TodoItem  findByUnassignedTodoItem() {
        for (TodoItem personStatus : todoItemStorage) {
            if (personStatus.getAssignee() == null) {
                return personStatus;
            }
        }
        return null;
    }

    @Override
    public void update(TodoItem toupdate) {
        if(toupdate == null) throw new IllegalArgumentException("city data was null");
        for(TodoItem OriginalTodoItem: todoItemStorage){
            if(OriginalTodoItem.getId()==toupdate.getId()){
                OriginalTodoItem.setId(toupdate.getId());
                OriginalTodoItem.setTitle(toupdate.getTitle());
                OriginalTodoItem.set_description(toupdate.get_description());
                OriginalTodoItem.setAssignee(toupdate.getAssignee());
                OriginalTodoItem.setDone(toupdate.isDone());
                OriginalTodoItem.setDeadLine(toupdate.getDeadLine());
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer id) {

            return  todoItemStorage.remove(findById(id));
        }
    }

