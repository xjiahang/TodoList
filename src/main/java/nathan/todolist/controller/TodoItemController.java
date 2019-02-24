package nathan.todolist.controller;

import lombok.extern.slf4j.Slf4j;
import nathan.todolist.model.TodoData;
import nathan.todolist.model.TodoItem;
import nathan.todolist.service.TodoItemService;
import nathan.todolist.util.Attributes;
import nathan.todolist.util.Mappings;
import nathan.todolist.util.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

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
    public String get_add_item(@RequestParam (required = false, defaultValue = "-1")int id, Model model) {
        TodoItem item;
        if (id == -1) {
            item = new TodoItem("", null);
        } else {
            item = service.getItem(id);
            //if item is null, what to return?
            if (item == null) {
                return "redirect:/" + Mappings.ITEMS;
            }

        }

        log.info("todoItem = {}", item.toString());
        model.addAttribute(Attributes.TODO_ITEM, item);

        return Views.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String post_add_item(@ModelAttribute(Attributes.TODO_ITEM) TodoItem todoItem) {
        if (todoItem.getId() == 0)
            service.addItem(todoItem);
        else
            service.updateItem(todoItem);
        log.info("post_add_item todoItem {}", todoItem);

        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String delete_item(@RequestParam int id) {
        //how do we know which item to delete when click delete url.
        //does that url carry some info?
        log.info("delete id {}", id);
        service.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }


}
