package com.todo.todo_backend.controller;

import com.todo.todo_backend.model.Todo;
import com.todo.todo_backend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String home(){
        return "Hello";
    }
    @PostMapping("/add")
    public ResponseEntity<String> addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAllTodos(){
        return todoService.getAllTodos();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id){
        return todoService.deleteById(id);
    }

    @GetMapping("/totalcount")
    public ResponseEntity<Integer> getTotalCount(){
        return todoService.getTotalTodosCount();
    }

    @GetMapping("/completedcount")
    public ResponseEntity<Integer> getCompletedCount(){
        return todoService.getCompletedTodosCount();
    }

    @DeleteMapping("/delete/completed")
    public ResponseEntity<String> deleteCompleted(){
        return todoService.deleteCompletedTodos();
    }

    @PutMapping("/complete/all")
    public ResponseEntity<String> completeAllTasks(){
        return todoService.completeAllTodos();
    }
}
