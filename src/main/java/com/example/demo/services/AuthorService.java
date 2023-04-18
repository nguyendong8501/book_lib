package com.example.demo.services;

//import org.springframework.stereotype.Service;

import com.example.demo.models.Author;

public interface AuthorService {
	Author findAuthorById(Long id);
}
