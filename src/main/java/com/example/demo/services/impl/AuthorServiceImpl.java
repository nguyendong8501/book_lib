package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.book.Author;
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

//		Author addAuthor = new Author();
//		addAuthor.setName(author.getName());
//		addAuthor.getBooks().addAll(author.getBooks().stream().map(au -> {
//			Book book = bookRepository.findBookByTitle(au.getTitle());
//			book.getAuthors().add(addAuthor);
//			return book;
//		}).collect(Collectors.toList()));

		return authorRepository.save(author);
	}

	public Author updateAuthor(Author author, Long id) {
		Author updateAuthor = authorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Author not exist with id: " + id));
//		updateAuthor.setName(author.getName());
		return authorRepository.save(updateAuthor);
	}
	
	public List<Author> findAll(Pageable pageable){
		List<Author> results = new ArrayList<>();
		List<Author> entities = authorRepository.findAll(pageable).getContent();
		for(Author item: entities) {
			results.add(item);
		}
		return results;
	}
	
	public int totalItem() {
		return (int) authorRepository.count();
	}
}
