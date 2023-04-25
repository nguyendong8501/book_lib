package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Book;

public interface BookService {
	Book saveBook(Book book,MultipartFile file);
//	Book findById(Long id);
	Book updateBook(Book book,Long id);
	List<Book> findAll(Pageable pageable);
	int totalItem();
	void delete(Long id);
}
