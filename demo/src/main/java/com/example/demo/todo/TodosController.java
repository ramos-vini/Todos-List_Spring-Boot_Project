package com.example.demo.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodosController {

    /* Todos List */
    @GetMapping("todos-list")
    public String todosListView(Model model){
        List<Todo> todos = TodoService.getTodosByUser();
        model.addAttribute("todos", todos);
        return "todosList";
    }

    /* Adding Todos */
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

        TodoService.addTodo(todo);
        return "redirect:todos-list"; /* Redirect to the GET Link, not to the View doc */
    }

    /* Deleting Todos */
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        TodoService.deleteById(id);
        return "redirect:todos-list";
    }

    /* Updating Todos */
    @GetMapping("update-todo")
    public String updateTodoView(@RequestParam int id, ModelMap model){
        Todo todo = TodoService.findById(id);
        model.addAttribute("todo", todo);
        return "updateTodo";
    }

    @PostMapping("update-todo")
    public String updateTodo(@Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "updateTodo";
        }
        TodoService.updateTodo(todo);
        return "redirect:todos-list";
    }

}
