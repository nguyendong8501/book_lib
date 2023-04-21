package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.example.demo.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	Book findBookById(Long id);
}
