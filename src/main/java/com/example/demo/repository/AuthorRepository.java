package com.example.demo.repository;

//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findAuthorById(Long id);
}
