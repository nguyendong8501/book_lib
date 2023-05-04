package com.example.demo.payload.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Book;

public class BookResponse extends BaseResponse {
	private List<Book> books = new ArrayList<>();

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
