package nathan.todolist.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Objects;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {
    // == fields ==
    int id;
    String details;
    LocalDate deadline;

    //== constructor ==
    public TodoItem(String details, LocalDate deadline) {
        this.details = details;
        this.deadline = deadline;
    }

}
