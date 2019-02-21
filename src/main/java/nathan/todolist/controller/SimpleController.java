package nathan.todolist.controller;

import nathan.todolist.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
    //== fields ==
    DemoService service;

    // == constructor ==
    @Autowired
    public SimpleController(DemoService service) {
        this.service = service;
    }

    // == controller ==
    @GetMapping(value="hello")
    @ResponseBody
    public String hello() {
        return "hello world!";
    }


    @GetMapping(value="welcome")
    public String welcome(@RequestParam String user,  Model model) {
        model.addAttribute("user", service.getHelloMessage(user));
        return "welcome";
    }
}
