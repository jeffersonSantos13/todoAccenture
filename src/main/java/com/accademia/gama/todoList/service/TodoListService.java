package com.accademia.gama.todoList.service;

import com.accademia.gama.todoList.entity.TodoList;
import com.accademia.gama.todoList.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoListService {

    @Autowired
    private TodoListRepository repository;

    public TodoList saveTodoList(TodoList todoList) {
        return repository. save(todoList);
    }

    public List<TodoList> getAllTodoList() {
        return (List<TodoList>) repository.findAll();
    }

    public TodoList getTodoListById(int todoListId) {
        return repository.findById(todoListId)
                .orElseThrow();
    }

    public TodoList putTodoList(int todoListId, TodoList todoList) {
        TodoList todoListUpdated = repository.findById(todoListId).orElseThrow();
        todoListUpdated.setDescription(todoList.getDescription());
        todoListUpdated.setComplete(todoList.isComplete());
        todoListUpdated.setTitle(todoList.getTitle());
        repository.save(todoListUpdated);
        return todoListUpdated;
    }

    public List<TodoList> getAllTodoListCompleted() {
        List<TodoList> listsTodoList = (List<TodoList>) repository.findAll();
        listsTodoList.removeIf(list -> !list.isComplete());
        return listsTodoList;
    }

    public List<TodoList> getAllTodoListIsNotCompleted() {
        List<TodoList> listsTodoList = (List<TodoList>) repository.findAll();
        listsTodoList.removeIf(TodoList::isComplete);
        return listsTodoList;
    }

    public Object getTodoListByIdDescription(int todoListId) {
        TodoList todoList = repository.findById(todoListId).orElse(new TodoList());

        return todoList.getDescription();
    }

    public void deleteTodoList(int todoListId) {
        TodoList deleteTodoList = repository.findById(todoListId).orElseThrow();
        repository.delete(deleteTodoList);
    }
}
