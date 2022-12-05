package com.example.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Book;

@Repository
public class BookRepo {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Book saveBook(Book book) {
		return mongoTemplate.save(book);
	}
}
