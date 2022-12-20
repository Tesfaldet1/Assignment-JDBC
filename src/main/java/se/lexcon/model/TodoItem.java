package se.lexcon.model;

public class TodoItem {
    private int id;
    private String title;
    private String _description;

    public TodoItem(String title, String _description) {
        this.title = title;
        this._description = _description;
    }

    public TodoItem(int id, String title, String _description) {
        this.id = id;
        this.title = title;
        this._description = _description;
    }

    public TodoItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", _description='" + _description + '\'' +
                '}';
    }
}
