package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Book;

@Repository
public class BookRepo {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Book saveBook(Book book) {
		return mongoTemplate.save(book);
	}
	
	//Projections
	//The include() and exclude() methods on the Field class is used to include and exclude fields respectively
	public List<Book> getBookNameList() {
		Query query = new Query();
		query.fields().include("name").exclude("id");
		List<Book> books = mongoTemplate.find(query, Book.class);
		return books;
	}
}
