package nathan.todolist.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {
    // == fields ==
    int id;
    String details;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    LocalDate deadline;

    //== constructor ==
    public TodoItem(String details, LocalDate deadline) {
        this.details = details;
        this.deadline = deadline;
    }

}
