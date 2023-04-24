package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.models.Book;

public interface BookService {
	Book saveBook(Book book);
//	Book findById(Long id);
	Book updateBook(Book book,Long id);
	List<Book> findAll(Pageable pageable);
	int totalItem();
}
