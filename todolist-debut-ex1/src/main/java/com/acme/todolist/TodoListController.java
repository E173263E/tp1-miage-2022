package com.acme.todolist;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Le controlleur Spring MVC qui expose les endpoints REST
 * 
 * @author bflorat
 *
 */
@RestController
public class TodoListController {

	private static final String LATE = "[LATE!]";
	private TodoItemRepository todoItemRepository;

	@Inject
	public TodoListController(TodoItemRepository todoItemRepository) {
		super();
		this.todoItemRepository = todoItemRepository;
	}
	
	public TodoListController() {
		super();		
	}

	@PostMapping("/todos")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createTodoItem(@RequestBody TodoItem todoItem) {
		// Code à compléter
		this.todoItemRepository.save(todoItem);
	}

	@GetMapping("/todos")
	public List<TodoItem> todoItems() {
		return this.todoItemRepository.findAll().stream()
				.map(item -> new TodoItem(item.getId(), item.getTime(), finalContent(item)))
				.collect(Collectors.toList());

	}

	/**
	 * RG 1 : si l'item a plus de 24h, ajouter dans le contenu une note "[LATE!]"
	 * 
	 * @return liste des items
	 */
	private String finalContent(TodoItem item) {
		return (Instant.now().isAfter(item.getTime().plus(1, ChronoUnit.DAYS))) ? 
				LATE + item.getContent()
				: item.getContent();
	}

}
