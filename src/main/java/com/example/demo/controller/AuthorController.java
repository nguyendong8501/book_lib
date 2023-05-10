package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Author;
import com.example.demo.payload.response.PageableResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.services.AuthorService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "api/auth")
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping(value = "/addauthor")
//	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> saveAuthor(@RequestBody Author author) {
		if (authorRepository.existsByName(author.getName())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Author name is already taken!"));
		}
		return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateauthor/{id}")
//	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public ResponseEntity<?> updateAuthor(@RequestBody Author author, @PathVariable long id) {
		if (authorRepository.existsByName(author.getName())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Author name is already taken!"));
		}
		return new ResponseEntity<>(authorService.updateAuthor(author, id), HttpStatus.CREATED);
	}

	@GetMapping(value = "/author")
//	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
	public PageableResponse showBook(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		PageableResponse result = new PageableResponse();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListAuthor(authorService.findAll(pageable));
		result.setTotalPage((int) Math.ceil( (double)(authorService.totalItem()) / limit));
		return result;
	}
	@DeleteMapping(value = "/author/{id}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
		authorRepository.deleteById(id);
		return new ResponseEntity<>(new MessageResponse("Deleted successfully"),HttpStatus.OK);
	}
}
