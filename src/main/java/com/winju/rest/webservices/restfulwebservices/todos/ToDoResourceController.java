package com.winju.rest.webservices.restfulwebservices.todos;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.winju.rest.webservices.restfulwebservices.todos.TodosBean;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ToDoResourceController {
	
	@Autowired
	private TodoHardCodedService todoService;
	
	//Get All Todos
	@GetMapping(path="/users/{username}/todos")
	public List<TodosBean> getAllTodos(@PathVariable String username) {
		return todoService.findAll();		
	}
	
	//Add a Specific Todo
	@GetMapping(path="/users/{username}/todos/{id}")
	public TodosBean getSpecificTodos(@PathVariable long id) {
		return todoService.findById(id);		
	}
	
	//Update a Specific Todo
	@PutMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<TodosBean> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody TodosBean todo) {
		TodosBean todosCheck = todoService.save(todo);	
		return new ResponseEntity<TodosBean>(todosCheck, HttpStatus.OK);
	}
	
	
	//Insert a new Todo
	@PostMapping(path="/users/{username}/todos")
	public ResponseEntity<TodosBean> insertTodo(@PathVariable String username, @RequestBody TodosBean todo) {
		
		TodosBean todosCheck = todoService.save(todo);	
		
		//Get current resource url
		//Append the the new Todo created and send it back so that the client can view new TOdo in JSON format!!
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(todosCheck.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Delete a specific Todo
	@DeleteMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteSpecificTodo(@PathVariable String username, @PathVariable long id) {
		TodosBean todo =  todoService.deleteById(id);	
		if(todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
