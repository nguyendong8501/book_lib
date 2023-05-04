package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Book;
import com.example.demo.payload.request.BookRequest;

public interface BookService {
	void saveBook(BookRequest bookRequest);
//	Book findById(Long id);
	void updateBook(BookRequest bookRequest,Long id);
	List<Book> findAll(Pageable pageable);
	int totalItem();
	void delete(Long id);
}
