package com.accademia.gama.todoList.controller;

import com.accademia.gama.todoList.entity.TodoList;
import com.accademia.gama.todoList.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{todoListId}")
    public ResponseEntity<TodoList> updateTodoList(@PathVariable int todoListId, @RequestBody TodoList todoList) {
        return ResponseEntity.ok(service.putTodoList(todoListId, todoList));
    }

    @GetMapping("/todoListComplete")
    public ResponseEntity<List<TodoList>> getAllTodoListCompleted() {
        return ResponseEntity.ok(service.getAllTodoListIsCompleted(true));
    }

    @GetMapping("/todoListIsNotComplete")
    public ResponseEntity<List<TodoList>> getAllTodoListIsNotCompleted() {
        return ResponseEntity.ok(service.getAllTodoListIsCompleted(false));
    }

    @GetMapping("/{todoListId}/description")
    public ResponseEntity<Object> updateTodoList(@PathVariable int todoListId) {
        return ResponseEntity.ok(service.getTodoListByIdDescription(todoListId));
    }

    @DeleteMapping("/{todoListId}")
    public ResponseEntity<String> deleteTodoList(@PathVariable int todoListId) {
        service.deleteTodoList(todoListId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
