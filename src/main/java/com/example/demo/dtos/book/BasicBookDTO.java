package com.example.demo.dtos.book;

import java.util.Collection;

import com.example.demo.dtos.DTO;

public class BasicBookDTO implements DTO {
	private Long id;
	private String title;
	private String short_description;
	private String description;
	private Collection<String> authors;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShort_description() {
		return short_description;
	}
	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<String> getAuthors() {
		return authors;
	}
	public void setAuthors(Collection<String> authors) {
		this.authors = authors;
	}
	
	
}
