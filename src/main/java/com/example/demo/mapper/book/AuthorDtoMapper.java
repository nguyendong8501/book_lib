package com.example.demo.mapper.book;

import org.springframework.stereotype.Component;

import com.example.demo.models.book.Author;

@Component
public class AuthorDtoMapper {
	public String map(Author author) {
		return author.getFirstName() + " " + author.getLastName();
	}
}
