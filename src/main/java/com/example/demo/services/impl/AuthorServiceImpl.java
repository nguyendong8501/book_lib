package com.example.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.services.AuthorService;
@Service
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author findAuthorById(Long id) {
        return authorRepository.findAuthorById(id);
    }
}
