package com.acme.todolist.application.service;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.port.out.UpdateTodoItem;
import com.acme.todolist.domain.TodoItem;

@Component
public class AddTodoItemService implements AddTodoItem {

	private UpdateTodoItem updateTodoItem;

	//A compléter
	@Inject
	public AddTodoItemService(UpdateTodoItem updateTodoItem) {
		this.updateTodoItem = updateTodoItem;
	}
	
	@Override
	public void addTodoItem(TodoItem item) {
		// TODO Auto-generated method stub
		this.updateTodoItem.storeNewTodoItem(item);
		
	}
	
	public UpdateTodoItem getUpdateTodoItem() {
		return updateTodoItem;
	}
	
	public void setUpdateTodoItem(UpdateTodoItem updateTodoItem) {
		this.updateTodoItem = updateTodoItem;
	}
}