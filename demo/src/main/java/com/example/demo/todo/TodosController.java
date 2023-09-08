package com.example.demo.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public String addTodoView(Model model){
        Todo todo = new Todo();
        model.addAttribute("todo", todo); /* This object name has to match the model name used in the html form */
        return "addTodo";
    }

    @PostMapping("add-todo")
    public String addTodo(@Valid Todo todo, BindingResult result){ /* This object name is optional */
        if(result.hasErrors()){
            return "addTodo"; /* html file name */
        }

        TodoService.addTodo(todo.getDescription());
        return "redirect:todos-list"; /* Redirect to the GET Link, not to the View doc */
    }
}
