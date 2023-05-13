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
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dtos.book.AddBookDTO;
import com.example.demo.models.book.Book;
import com.example.demo.payload.request.BookRequest;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.payload.response.PageableResponse;
import com.example.demo.services.BookService;
//import com.example.demo.services.FilesStorageService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/api/auth")
public class BookController {
	@Autowired
	private BookService bookService;

//	@Autowired
//	private FilesStorageService filesStorageService;
//	@Autowired
//	private BookRepository bookRepository;

	@PostMapping(value = "/addbook")
	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")

	public ResponseEntity<?> saveBook(@RequestBody AddBookDTO book) {
//		filesStorageService.getImage(file);
		bookService.saveBook(book);
		return new ResponseEntity<>(new MessageResponse("Create successfull"), HttpStatus.CREATED);
	}

	@PutMapping(value = "/updatebook/{id}")
//	@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")

	public ResponseEntity<?> updateBook(@RequestBody BookRequest book, @PathVariable long id) {
		bookService.updateBook(book, id);
		return new ResponseEntity<>(new MessageResponse("Update successfull"), HttpStatus.OK);
	}

	@GetMapping(value = "/book")

	public PageableResponse showBook(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		PageableResponse result = new PageableResponse();
		result.setPage(page);
		Pageable pageable = PageRequest.of(page - 1, limit);
		result.setListResult(bookService.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (bookService.totalItem()) / limit));
		return result;
	}

	@DeleteMapping(value = "/book/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable long id) {
		bookService.delete(id);
		return new ResponseEntity<>(new MessageResponse("Deleted successfully"), HttpStatus.OK);
	}
}
