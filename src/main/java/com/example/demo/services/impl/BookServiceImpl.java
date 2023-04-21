package com.example.demo.services.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorService authorService;

	public Book saveBook(Book book) {

		Book addBook = new Book();
		addBook.setTitle(book.getTitle());
		addBook.setShort_description(book.getShort_description());
		addBook.setDescription(book.getDescription());
		addBook.setUrl(book.getUrl());
		addBook.getAuthors().addAll(book.getAuthors().stream().map(au -> {
			Author author = authorService.findAuthorById(au.getId());
			author.getBooks().add(addBook);
			return author;
		}).collect(Collectors.toList()));
		
		return bookRepository.save(addBook);
	}
	public Book updateBook(Book book,Long id) {
		Book updateBook = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not exist with id: " + id));
		updateBook.setTitle(book.getTitle());
		updateBook.setShort_description(book.getShort_description());
		updateBook.setDescription(book.getDescription());
		updateBook.setUrl(book.getUrl());
		updateBook.getAuthors().addAll(book.getAuthors().stream().map(au->{
			Author author = authorService.findAuthorById(au.getId());
			author.getBooks().add(updateBook);
			return author;
		}).collect(Collectors.toList()));
		return bookRepository.save(updateBook);
	}
}
