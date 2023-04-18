package com.example.demo.services.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Author;
import com.example.demo.models.Book;
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
		addBook.setUrl(book.getTitle());
		addBook.getAuthors().addAll(book.getAuthors().stream().map(au -> {
			Author author = authorService.findAuthorById(au.getId());
			Collection<Book> bookList = author.getBooks();
			bookList.add(addBook);
//			author.getName().add(addBook);
//			author.getUrl().add(addBook);
			return author;
		}).collect(Collectors.toList()));
		return bookRepository.save(addBook);
	}
}
