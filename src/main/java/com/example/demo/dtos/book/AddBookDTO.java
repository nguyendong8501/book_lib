package com.example.demo.dtos.book;

import java.util.Collection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.dtos.DTO;

public class AddBookDTO implements DTO {
	@NotNull
	private Long id;
	@NotEmpty
	private String title;
	@NotEmpty
	private String short_description;
	@NotEmpty
	private String description;
	@NotEmpty
	private String url;
	@NotEmpty
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Collection<String> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<String> authors) {
		this.authors = authors;
	}

}
