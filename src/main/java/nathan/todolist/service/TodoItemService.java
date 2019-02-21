package nathan.todolist.service;

import nathan.todolist.model.TodoData;
import nathan.todolist.model.TodoItem;

public interface TodoItemService {
    public void addItem(TodoItem item);
    public void removeItem(int id);
    public TodoItem getItem(int id);
    public void updateItem(TodoItem item);
    public TodoData getData();
}
