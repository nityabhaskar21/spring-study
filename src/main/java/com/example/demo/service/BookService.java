package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookCreateRequest;
import com.example.demo.dto.BookProperties;
import com.example.demo.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;

	public Book saveBook(@Valid BookCreateRequest bookCreateRequest) {
		var book = Book.builder().name(bookCreateRequest.getName()).author(bookCreateRequest.getAuthor())
				.tags(bookCreateRequest.getTags()).cost(bookCreateRequest.getCost()).pages(bookCreateRequest.getPages())
				.properties(BookProperties.builder().genre(bookCreateRequest.getBookProperties().get("genre"))
						.publisher(bookCreateRequest.getBookProperties().get("publisher")).build())
				.build();
		return bookRepo.saveBook(book);
	}

	public List<Book> getBookNameList() {
		var books = bookRepo.getBookNameList();
		return books;
	}

}
