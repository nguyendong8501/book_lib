package com.example.demo.converter;

import org.springframework.stereotype.Component;

import com.example.demo.models.Book;
import com.example.demo.payload.request.BookRequest;

@Component
public class BookConverter {
	public Book toEntity(BookRequest request) {
		Book entity = new Book();
		entity.setTitle(request.getTitle());
		entity.setShort_description(request.getShort_description());
		entity.setDescription(request.getDescription());
		entity.setUrl(request.getUrl());
		return entity;
	}

	public BookRequest toRequest(Book entity) {
		BookRequest request = new BookRequest();
		if (entity.getId() == null) {
			request.setId(entity.getId());
		}
		request.setTitle(entity.getTitle());
		request.setShort_description(entity.getShort_description());
		request.setDescription(entity.getDescription());
		request.setUrl(entity.getUrl());

		return request;
	}

	public Book toEntity(BookRequest request, Book entity) {
		entity.setTitle(request.getTitle());
		entity.setShort_description(request.getShort_description());
		entity.setDescription(request.getDescription());
		entity.setUrl(request.getUrl());
		return entity;
	}
}
