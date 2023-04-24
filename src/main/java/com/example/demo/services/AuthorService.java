package com.example.demo.services;

//import org.springframework.stereotype.Service;

import com.example.demo.models.Author;

public interface AuthorService {
	Author findAuthorByName(String name);
	Author findAuthorById(Long id);
	Author saveAuthor(Author author);

}
