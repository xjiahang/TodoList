package nathan.todolist.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Objects;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {
    static int global_id = 0;
    // == fields ==
    int id;
    String details;
    LocalDate deadline;

    //== constructor ==
    public TodoItem(String details, LocalDate deadline) {
        global_id++;
        this.id = global_id;
        this.details = details;
        this.deadline = deadline;
    }

}
