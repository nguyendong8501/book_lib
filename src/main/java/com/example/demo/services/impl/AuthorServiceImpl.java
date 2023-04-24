package com.example.demo.services.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;

	public Author findAuthorById(Long id) {
		return authorRepository.findAuthorById(id);
	}
	public Author findAuthorByName(String name) {
		return authorRepository.findAuthorByName(name);
	}
	public Author saveAuthor(Author author) {
		
		Author addAuthor = new Author();
//		addAuthor.setName(author.getName());
//		addAuthor.getBooks().addAll(author.getBooks().stream().map(au -> {
//			Book book = bookRepository.findBookByTitle(au.getTitle());
//			book.getAuthors().add(addAuthor);
//			return book;
//		}).collect(Collectors.toList()));

		return authorRepository.save(addAuthor);
	}
}
