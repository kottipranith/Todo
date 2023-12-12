package com.todo.todo_backend.service;

import com.todo.todo_backend.model.Todo;
import com.todo.todo_backend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepository todoRepository;
    @Override
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        if(todos.size() == 0)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(todos,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(int id) {
        todoRepository.deleteById(id);
        return new ResponseEntity<>("Task Deleted",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getCompletedTodosCount() {
        return new ResponseEntity<>(todoRepository.getCompletedCount(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getTotalTodosCount() {
        return new ResponseEntity<>(todoRepository.getTotalCount(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addTodo(Todo todo) {
        todoRepository.save(todo);
        return new ResponseEntity<>("Task Added",HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<String> deleteCompletedTodos() {
        todoRepository.deleteCompletedTasks();
        return new ResponseEntity<>("Completed Tasks Deleted",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> completeAllTodos() {
        todoRepository.completeAllTasks();
        return new ResponseEntity<>("All Tasks Completed",HttpStatus.OK);
    }
}
