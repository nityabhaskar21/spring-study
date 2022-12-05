package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.example.demo.dto.BookProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "books")
@Builder
@JsonInclude(Include.NON_NULL) //only include non-null fiels in the result.
public class Book {

      @Id
      private String id;
      private String name;
      private Integer pages;
      private String author;
      private Double cost;
      @Field(name = "properties")
      private BookProperties properties;
}
