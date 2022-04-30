package com.acme.todolist.domain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Un item à faire, immuable
 * 
 * @author bflorat
 *
 */
public class TodoItem {

	private static final String LATE = "[LATE!] ";

	private String id;

	private Instant time;

	private String content;

	public String getId() {
		return id;
	}

	public Instant getTime() {
		return time;
	}

	public String getContent() {
		return this.content;
	}

	/**
	 * Constructeur vide imposé par JPA, ne pas utiliser
	 */
	protected TodoItem() {
	}

	public TodoItem(String id, Instant time, String content) {
		super();
		this.id = id;
		this.time = time;
		this.content = content;
	}

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", time=" + time + ", content=" + content + "]";
	}

	boolean isLate() {
		return Instant.now().isAfter(getTime().plus(1, ChronoUnit.DAYS));
	}

	/**
	 * RG 1 : si l'item a plus de 24h, ajouter dans le contenu une note "[LATE!]"
	 * 
	 * @return liste des items
	 */
	public String finalContent() {
		return isLate() ? LATE + this.content : this.content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoItem other = (TodoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
