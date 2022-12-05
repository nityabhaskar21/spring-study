package com.example.demo.dto;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookCreateRequest {
	@NotEmpty(message = "Name is mandatory")
	@Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters long")
	@Pattern(regexp="^[a-zA-Z0-9-_]*$", message="Name should be AlphaNumeric with Hyphen or Underscore.")
	private String name;
	
	private Integer pages;
	private String author;
	private Double cost;
	@JsonProperty("properties")
	private Map<String, String> bookProperties;
	private List<String> tags;
}
