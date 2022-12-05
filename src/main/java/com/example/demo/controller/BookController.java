package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookCreateRequest;
import com.example.demo.service.BookService;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping(value = "/{save-book}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Book> createBook( @Valid @RequestBody BookCreateRequest bookCreateRequest) {
		var book = bookService.saveBook(bookCreateRequest);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{get-book-names}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Book> > getBookNameList() {
		var books = bookService.getBookNameList();
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
}
