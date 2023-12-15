package com.todo.todo_backend.repository;

import com.todo.todo_backend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository<Todo,Integer> {
    @Query("select count(*) from Todo t")
    public Integer getTotalCount(); 
    @Query("select count(*) from Todo t where t.status='completed'")
    public Integer getCompletedCount();



    public void deleteByStatus(String status);

    @Query("update Todo t set t.status='completed' where t.status='pending'")
    public void completeAllTasks(); 
}
