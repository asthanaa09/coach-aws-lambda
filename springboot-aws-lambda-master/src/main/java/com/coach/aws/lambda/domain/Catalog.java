package com.coach.aws.lambda.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "catalog")
@Setter
@Getter
public class Catalog extends BaseEntity {

	public static final String SEQUENCE_KEY = "catalog_sequence";
	
	@DBRef
	Student student;
	@DBRef
	Subject subject;
	
	boolean removed;
}
