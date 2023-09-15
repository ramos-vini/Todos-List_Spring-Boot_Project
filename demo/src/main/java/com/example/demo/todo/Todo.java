package com.example.demo.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    public Todo() {
    }

    public Todo(int id, String username, String description, LocalDate dueDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.dueDate = dueDate;
        this.done = done;
    }

    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min = 5, message = "Enter at least 5 characters")
    private String description;
    private LocalDate dueDate;
    private boolean done;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /* Attention to boolean getters */
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
