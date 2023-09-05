package com.example.demo.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodosController {

    @GetMapping("todos-list")
    public String todosListView(Model model){

        List<Todo> todos = TodoService.getTodos();
        model.addAttribute("todos", todos);
        return "todosList";
    }

    @GetMapping("add-todo")
    public String addTodoView(){
        return "addTodo";
    }

    @PostMapping("add-todo")
    public String addTodo(@RequestParam String description){
        TodoService.addTodo(description);
        return "redirect:todos-list"; /* Redirect to the GET Link, not to the View doc */
    }
}
