//package com.example.demo.services.impl;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.example.demo.dtos.book.AddBookDTO;
//import com.example.demo.dtos.book.BasicBookDTO;
//import com.example.demo.dtos.pagination.PageDTO;
//import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.models.book.Author;
//import com.example.demo.models.book.Book;
//import com.example.demo.models.user.User;
//import com.example.demo.payload.request.BookRequest;
//import com.example.demo.repository.AuthorRepository;
//import com.example.demo.repository.BookRepository;
//import com.example.demo.services.AuthorService;
//import com.example.demo.services.BookService;
////import com.example.demo.services.FilesStorageService;
//
//@Service
//public class BookServiceImpl implements BookService {
//	@Autowired
//	private BookRepository bookRepository;
//
//	@Autowired
//	private AuthorService authorService;
//	@Autowired
////	@Autowired
////	private FilesStorageService filesStorageService;
//
////	@Autowired
////	private AuthorRepository authorRepository;
//	@Override
//	public void saveBook(AddBookDTO bookRequest) {
//
//		Book addBook = new Book();
//		addBook.setTitle(bookRequest.getTitle());
////		addBook.setShort_description(bookRequest.getShort_description());
//		addBook.setDescription(bookRequest.getDescription());
////		addBook.set(bookRequest.getUrl());
////		addBook.setUrl(filesStorageService.getImage(file));
//		for (String authorName : bookRequest.getAuthors()) {
//			Author author = authorService.findAuthorByName(authorName);
//			if (author != null) {
//				author.getBooks().add(addBook);
//				addBook.getAuthors().add(author);
//			} else {
//				Author newAuthor = new Author();
//				newAuthor.setName(authorName);
//				addBook.getAuthors().add(newAuthor);
//				newAuthor.getBooks().add(addBook);
//			}
//		}
//
//		bookRepository.save(addBook);
////		return bookConverter.toDTO(addBook);
//	}
//
//	@Override
//	public void updateBook(BookRequest bookRequest, Long id) {
//		Book updateBook = bookRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Book not exist with id: " + id));
//		updateBook.setTitle(bookRequest.getTitle());
////		updateBook.setShort_description(bookRequest.getShort_description());
//		updateBook.setDescription(bookRequest.getDescription());
////		updateBook.setUrl(bookRequest.getUrl());
//		updateBook.getAuthors().clear();
//
//		for (String authorName : bookRequest.getAuthors()) {
//			Author author = authorService.findAuthorByName(authorName);
//			if (author != null) {
//				author.getBooks().add(updateBook);
//				updateBook.getAuthors().add(author);
//			} else {
//				Author newAuthor = new Author();
//				newAuthor.setName(authorName);
//				updateBook.getAuthors().add(newAuthor);
//				newAuthor.getBooks().add(updateBook);
//			}
//		}
//
//		bookRepository.save(updateBook);
//	}
//
//	@Override
//	public List<Book> findAll(Pageable pageable) {
//		List<Book> results = new ArrayList<>();
//		List<Book> entities = bookRepository.findAll(pageable).getContent();
//		for (Book item : entities) {
//			results.add(item);
//		}
//		return results;
//	}
//
//	@Override
//	public int totalItem() {
//		return (int) bookRepository.count();
//	}
//
//	@Override
//	public void delete(Long id) {
//		bookRepository.deleteById(id);
//	}
//	
////	@Override
////	public PageDTO<BasicBookDTO> getPage(int page,int limit){
////		
////		
////		PageDTO<BasicBookDTO> results = new PageDTO<>();
////		results.setListResult(bookRepository.findAll(PageRequest.of(page - 1, limit)));
//////			results.setListResult(bookRepository.findAll(pageable).getContent());
////		
////		
////		return results;
////	}
//}
