package nathan.todolist.service;

import lombok.Getter;
import nathan.todolist.model.TodoData;
import nathan.todolist.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoItemSeviceImpl implements TodoItemService {
    // fields
    @Getter
    private final TodoData data = new TodoData();

    // public methods
    @Override
    public void addItem(TodoItem item) {
        data.addItem(item);
    }

    @Override
    public void removeItem(int id) {
        data.deleteItemById(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItemById(id);
    }

    @Override
    public void updateItem(TodoItem item) {
        data.updateItem(item);
    }

}
