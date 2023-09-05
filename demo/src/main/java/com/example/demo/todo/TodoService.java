package com.example.demo.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();

    private static int todosCounter = 0;

    static{
        todos.add(new Todo(++todosCounter,"Learn Spring Boot", LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(++todosCounter,"Learn AWS", LocalDate.now().plusMonths(2), false));
        todos.add(new Todo(++todosCounter,"Learn Docker", LocalDate.now().plusMonths(3), false));
    }

    public static List<Todo> getTodos(){
        return todos;
    }

    public static void addTodo(String description){
        todos.add(new Todo(++todosCounter, description, LocalDate.now().plusMonths(1), false));
    }
}
