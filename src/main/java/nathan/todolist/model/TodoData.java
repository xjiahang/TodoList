package nathan.todolist.model;

import lombok.NonNull;

import java.awt.image.TileObserver;
import java.time.LocalDate;
import java.util.*;

public class TodoData {
    // fields
    private final List<TodoItem>  items = new ArrayList<>();
    private static  int itemId = 1;
    // constructors
    public TodoData() {
        addItem(new TodoItem("first", LocalDate.now()));
        addItem(new TodoItem("second", LocalDate.now()));
    }

    // methods
    public void addItem(@NonNull TodoItem toAdd) {

        toAdd.setId(itemId);
        itemId++;
        items.add(toAdd);
    }

    public TodoItem getItemById(int id) {
        for (TodoItem item: items ) {
            if (item.getId() == id)
                return item;
        }

        return null;
    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean deleteItemById(int id) {
        Iterator<TodoItem> iter = items.iterator();
        while (iter.hasNext()) {
            if (iter.next().getId() == id) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    public boolean updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> iter = items.listIterator();
        while (iter.hasNext()) {
            TodoItem item = iter.next();
            if (item.equals(toUpdate)) {
                iter.set(toUpdate);
                return true;
            }
        }
        return false;
    }
}
