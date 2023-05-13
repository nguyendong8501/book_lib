package com.example.demo.repository;

//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.models.book.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findAuthorById(Long id);
	Author findAuthorByName(String name);
	Boolean existsByName(String name);
}
