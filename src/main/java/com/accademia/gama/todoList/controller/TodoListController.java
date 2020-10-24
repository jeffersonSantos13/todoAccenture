package com.accademia.gama.todoList.controller;

import com.accademia.gama.todoList.entity.TodoList;
import com.accademia.gama.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todoList")
public class TodoListController {

    @Autowired
    private TodoListService service;

    @PostMapping
    public ResponseEntity<TodoList> createNewTodoList(@RequestBody TodoList todoList) {
        TodoList savedTodoList = service.saveTodoList(todoList);

        return ResponseEntity.ok(savedTodoList);
    }

    @GetMapping
    public ResponseEntity<List<TodoList>> getAllTodoList() {
        return ResponseEntity.ok(service.getAllTodoList());
    }

    @GetMapping("/{todoListId}")
    public ResponseEntity<TodoList> getTodoListById(@PathVariable int todoListId) {
        return ResponseEntity.ok(service.getTodoListById(todoListId));
    }

    @PutMapping
    public ResponseEntity<TodoList> updateTodoList(@PathVariable int todoListId, @RequestBody TodoList todoList) {
        TodoList saveTodoList = service.saveTodoList(todoList);

        return ResponseEntity.ok(service.getTodoListById(todoListId));
    }
}
