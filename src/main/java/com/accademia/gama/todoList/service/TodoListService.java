package com.accademia.gama.todoList.service;

import com.accademia.gama.todoList.entity.TodoList;
import com.accademia.gama.todoList.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoListService {

    @Autowired
    private TodoListRepository repository;

    public TodoList saveTodoList(TodoList todoList) {
        return repository.save(todoList);
    }

    public List<TodoList> getAllTodoList() {
        return (List<TodoList>) repository.findAll();
    }

    public TodoList getTodoListById(int todoListId) {
        return repository.findById(todoListId)
                .orElseThrow();
    }

   public TodoList updateTodoList(TodoList todoList) {
        return repository.save(todoList);
   }
}
