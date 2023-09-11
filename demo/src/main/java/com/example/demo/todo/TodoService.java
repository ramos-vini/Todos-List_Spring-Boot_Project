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
        todos.add(new Todo(++todosCounter,"vini", "Learn Spring Boot", LocalDate.now().plusMonths(1), false));
        todos.add(new Todo(++todosCounter,"vini", "Learn AWS", LocalDate.now().plusMonths(2), false));
        todos.add(new Todo(++todosCounter,"vini", "Learn Docker", LocalDate.now().plusMonths(3), false));
    }

    public static List<Todo> getTodosByUser(){
        return todos;
    }

    public static void addTodo(Todo todo){
        todos.add(new Todo(++todosCounter, todo.getUsername(), todo.getDescription(), todo.getDueDate(), false));
    }

    /* Keeps the same ID for updated Todos */
    public static void addTodoKeepId(Todo todo){
        todos.add(new Todo(todo.getId(), todo.getUsername(), todo.getDescription(), todo.getDueDate(), todo.isDone()));
    }

    public static Todo findById(int id){
        for (Todo todo : todos){
            if (todo.getId() == id) return todo;
        }
        return null;
    }

    public static void deleteById(int id){
        for (Todo todo : todos){
            if (todo.getId() == id){
                todos.remove(todo);
                return;
            }
        }
    }

    public static void updateTodo(Todo todo){
        deleteById(todo.getId());
        addTodoKeepId(todo);
    }

}
