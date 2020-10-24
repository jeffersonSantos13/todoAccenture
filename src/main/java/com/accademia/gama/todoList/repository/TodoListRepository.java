package com.accademia.gama.todoList.repository;

import com.accademia.gama.todoList.entity.TodoList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoListRepository extends CrudRepository<TodoList, Integer> {
    List<TodoList> findAllByComplete(boolean complete);
}
