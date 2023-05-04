package com.example.demo.payload.request;

import java.util.Collection;

public class AuthorRequest {
	private Long id;
	private String name;
	private Collection<String> books;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<String> getBooks() {
		return books;
	}

	public void setBooks(Collection<String> books) {
		this.books = books;
	}

}
