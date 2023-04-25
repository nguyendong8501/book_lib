package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.services.AuthorService;
import com.example.demo.services.BookService;
import com.example.demo.services.FilesStorageService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorService authorService;
	@Autowired
	private FilesStorageService filesStorageService;

//	@Autowired
//	private AuthorRepository authorRepository;
	@Override
	public Book saveBook(Book book,MultipartFile file) {

		Book addBook = new Book();
		addBook.setTitle(book.getTitle());
		addBook.setShort_description(book.getShort_description());
		addBook.setDescription(book.getDescription());
		
		addBook.setUrl(filesStorageService.getImage(file));
		
		addBook.getAuthors().addAll(book.getAuthors().stream().map(au -> {
			Author newAuthor = new Author();
			Author author = authorService.findAuthorByName(au.getName());
			if (author != null) {
				author.getBooks().add(addBook);
			} else {
				newAuthor.setName(au.getName());
				authorService.saveAuthor(newAuthor);
				Author updateAuthor = authorService.findAuthorByName(au.getName());
				updateAuthor.getBooks().add(addBook);
			}

			return author;
		}).collect(Collectors.toList()));

		return bookRepository.save(addBook);
	}

	@Override
	public Book updateBook(Book book, Long id) {
		Book updateBook = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not exist with id: " + id));
		updateBook.setTitle(book.getTitle());
		updateBook.setShort_description(book.getShort_description());
		updateBook.setDescription(book.getDescription());
		updateBook.setUrl(book.getUrl());
		updateBook.getAuthors().clear();
		updateBook.getAuthors().addAll(book.getAuthors().stream().map(au -> {
			Author author = authorService.findAuthorByName(au.getName());
//			author.getBooks().clear();
			author.getBooks().add(updateBook);
			return author;
		}).collect(Collectors.toList()));
		return bookRepository.save(updateBook);
	}

	@Override
	public List<Book> findAll(Pageable pageable) {
		List<Book> results = new ArrayList<>();
		List<Book> entities = bookRepository.findAll(pageable).getContent();
		for (Book item : entities) {
			results.add(item);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int) bookRepository.count();
	}

	@Override
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
}
