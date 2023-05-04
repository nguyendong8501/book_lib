package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.example.demo.models.Book;
import com.example.demo.payload.request.BookRequest;

public interface BookRepository extends JpaRepository<Book, Long> {
	Book findBookByTitle(String title);

	BookRequest save(BookRequest addBook);
}
