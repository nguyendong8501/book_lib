package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.models.book.Author;

public interface AuthorService {
	Author findAuthorByName(String name);
	Author findAuthorById(Long id);
	Author saveAuthor(Author author);
	Author updateAuthor(Author author,Long id);
	List<Author> findAll(Pageable pageable);
	int totalItem();
}
