package com.acme.todolist.domain;


import java.time.Instant;
import java.time.temporal.ChronoUnit;


import org.junit.jupiter.api.Test;

import com.acme.todolist.domain.TodoItem;

public class TodoItemTest {

	@Test
	void isLate_itemCreationDate20Minutes_afterCurrentTime_returnsFalse() {
		TodoItem item = new TodoItem("1",
				Instant.now().minus(20,ChronoUnit.MINUTES),"mycontent");
		
	}

	
	@Test
	void isLate_itemCreationDate20Minutes_beforeCurrentTime_returnsFalse() {
		TodoItem item = new TodoItem("1",
				Instant.now().plus(20,ChronoUnit.MINUTES),"mycontent");
		
	}	

	
}