package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dtos.book.AddBookDTO;
import com.example.demo.dtos.book.BasicBookDTO;
import com.example.demo.dtos.pagination.PageDTO;
import com.example.demo.models.book.Book;
import com.example.demo.payload.request.BookRequest;

public interface BookService {
	void saveBook(AddBookDTO bookRequest);
//	Book findById(Long id);
	void updateBook(BookRequest bookRequest,Long id);
	List<Book> findAll(Pageable pageable);
	int totalItem();
	void delete(Long id);
//	PageDTO<BasicBookDTO> getPage(int page,int limit);
}
