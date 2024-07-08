package com.restTemplet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restTemplet.entity.Todo;
import com.restTemplet.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
	
	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}



	// get single todo with id
	@GetMapping("/{id}")
	public Todo getSingleTodo(@PathVariable int id) {
		Todo todo = todoService.getTodo(id);
		return todo;
	}
	
	// get todos
	@GetMapping("/")
	public List<Todo> getTodos(){
		List<Todo> allTodo = todoService.getAllTodo();
		return allTodo;
	}
	
	// post todos
	@PostMapping("/")
	public Todo postTodo(@RequestBody Todo todo) {
		return todoService.createTodo(todo);
	}
}
