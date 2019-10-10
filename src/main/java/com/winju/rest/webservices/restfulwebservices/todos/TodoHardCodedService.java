package com.winju.rest.webservices.restfulwebservices.todos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class TodoHardCodedService {
	
	private static List<TodosBean> todos = new ArrayList();
	private static long idCounter = 0;
	
	
	static {
		todos.add(new TodosBean(++idCounter, "winju", "Learn To Dance", new Date(), false));
		todos.add(new TodosBean(++idCounter, "winju", "Learn About Micro-Services", new Date(), false));
		todos.add(new TodosBean(++idCounter, "winju", "Learn About ReactJS", new Date(), false));
		todos.add(new TodosBean(++idCounter, "lucky", "Learn How To Bark", new Date(), true));
		
	}
	
	public List<TodosBean> findAll() {
//		System.out.println("The data is "+todos.get(0).isDone());
		return todos;
	}
	
	//This will insert and update both
	public TodosBean save(TodosBean todo) {
		if(todo.getId() == -1 || todo.getId() == 0) { // for insertion
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	
	public TodosBean deleteById(long id) {
		TodosBean todo = findById(id);
		if(todo == null) return null;
		todos.remove(todo);
		if(todos.isEmpty()) {
			todos.add(new TodosBean(++idCounter, "winju", "Added again - Learn To Dance", new Date(), false));
			todos.add(new TodosBean(++idCounter, "winju", "Added again - Learn About Micro-Services", new Date(), false));
			todos.add(new TodosBean(++idCounter, "winju", "Added again - Learn About ReactJS", new Date(), false));
			todos.add(new TodosBean(++idCounter, "lucky", "Added again - Learn How To Bark", new Date(), true));
		}
		return todo;
	}

	public TodosBean findById(long id) {
		// TODO Auto-generated method stub
		for(TodosBean todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public TodosBean updateById(long id) {
		// TODO Auto-generated method stub
		for(TodosBean todo:todos) {
			if(todo.getId() == id) {
				
				return todo;
			}
		}
		return null;
	}

}
