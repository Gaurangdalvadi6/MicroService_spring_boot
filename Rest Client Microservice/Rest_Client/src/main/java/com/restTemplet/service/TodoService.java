package com.restTemplet.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.restTemplet.entity.Todo;

@Service
public class TodoService {

	private RestClient client;

	public TodoService(RestClient client) {
		super();
		this.client = client;
	}

	// get single todo
	public Todo getTodo(int id) {
		
		// call to api to get todo data
		Todo body = client.get()
				.uri("/todos/{id}",id)
				.retrieve()
				.body(Todo.class);
		return body;
	}
	
	// get all todos
	public List<Todo> getAllTodo(){
		
		// call to api to list of todo
		List<Todo> list = client.get()
			.uri("/todos")
			.retrieve()
			.body(new ParameterizedTypeReference<List<Todo>>() {
			});
		return list;
	}
	
	// create todo
	public Todo createTodo(Todo todo) {
		Todo body = client.post()
			.uri("/todos")
			.contentType(MediaType.APPLICATION_JSON)
			.body(todo)
			.retrieve()
			.body(Todo.class);
		return body;
	}
}