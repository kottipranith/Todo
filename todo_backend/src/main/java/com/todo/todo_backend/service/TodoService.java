package com.todo.todo_backend.service;

import com.todo.todo_backend.model.Todo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TodoService {
    public ResponseEntity<List<Todo>> getAllTodos();
    public ResponseEntity<String> deleteById(int id);
    public ResponseEntity<String> addTodo(Todo todo);
    public ResponseEntity<Integer> getCompletedTodosCount();
    public ResponseEntity<Integer> getTotalTodosCount();
    public ResponseEntity<String> deleteCompletedTodos();
    public ResponseEntity<String> completeAllTodos();
}
