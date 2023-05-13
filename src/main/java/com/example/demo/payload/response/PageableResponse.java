package com.example.demo.payload.response;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.book.Author;
import com.example.demo.models.book.Book;

public class PageableResponse {
	private int page;
	private int totalPage;
	private List<Book> listResult = new ArrayList<>();
	private List<Author> listAuthor = new ArrayList<>();
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Book> getListResult() {
		return listResult;
	}

	public void setListResult(List<Book> listResult) {
		this.listResult = listResult;
	}

	public List<Author> getListAuthor() {
		return listAuthor;
	}

	public void setListAuthor(List<Author> listAuthor) {
		this.listAuthor = listAuthor;
	}

}
