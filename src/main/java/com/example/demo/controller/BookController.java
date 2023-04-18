package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;

@CrossOrigin
@RestController(value = "/api/auth")
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping(value = "/addbook")
//	public Book addBook (@RequestBody Book book) {
//		return bookService.saveBook(book);
//	}
	public ResponseEntity<?> saveBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }
}
