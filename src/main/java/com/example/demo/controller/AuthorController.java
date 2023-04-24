package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Author;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.services.AuthorService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/auth")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping(value = "/addauthor")
	public ResponseEntity<?> saveAuthor(@RequestBody Author author) {
		if (authorRepository.existsByName(author.getName())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Authorname is already taken!"));
		}
		return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
	}
}
