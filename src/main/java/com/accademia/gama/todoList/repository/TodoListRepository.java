package com.accademia.gama.todoList.repository;

import com.accademia.gama.todoList.entity.TodoList;
import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoList, Integer> {

}
