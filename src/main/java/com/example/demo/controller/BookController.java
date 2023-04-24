package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.payload.response.BookResponse;
import com.example.demo.services.BookService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/auth")
public class BookController {
	@Autowired
	private BookService bookService;
//	@Autowired
//	private BookRepository bookRepository;

	@PostMapping(value = "/addbook")
//	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> saveBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
	}

	@PutMapping(value = "/updatebook/{id}")
//	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> updateBook(@RequestBody Book book, @PathVariable long id) {
		return new ResponseEntity<>(bookService.updateBook(book, id), HttpStatus.CREATED);
	}

	@GetMapping(value = "/book")
	
	public BookResponse showBook(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		BookResponse result = new BookResponse();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListResult(bookService.findAll(pageable));
		result.setTotalPage((int) Math.ceil( (double)(bookService.totalItem()) / limit));
		return result;
	}
}
