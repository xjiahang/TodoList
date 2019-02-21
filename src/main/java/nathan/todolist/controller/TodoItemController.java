package nathan.todolist.controller;

import lombok.extern.slf4j.Slf4j;
import nathan.todolist.model.TodoData;
import nathan.todolist.model.TodoItem;
import nathan.todolist.service.TodoItemService;
import nathan.todolist.util.Attributes;
import nathan.todolist.util.Mappings;
import nathan.todolist.util.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {
    // fields
    private final TodoItemService service;
    // constructors

    @Autowired
    public TodoItemController(TodoItemService service) {
        this.service = service;
    }

    @ModelAttribute("todoData")
    public TodoData todoData() {
        return service.getData();
    }

    @GetMapping(Mappings.ITEMS)
    public String items() {
        return Views.ITEMS;
    }

    //http://localhost:8080/TodoList/add_item
    @GetMapping(Mappings.ADD_ITEM)
    public String get_add_item(Model model) {
        TodoItem newItem = new TodoItem("", LocalDate.now());
        log.info("todoItem = {}", newItem.toString());
        model.addAttribute(Attributes.TODO_ITEM, newItem);
        return Views.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String post_add_item(@ModelAttribute(Attributes.TODO_ITEM)  TodoItem todoItem) {
        service.addItem(todoItem);
        log.info("post_add_item todoItem []", todoItem.toString());
        return "redirect:/" + Mappings.ITEMS;
    }

}
