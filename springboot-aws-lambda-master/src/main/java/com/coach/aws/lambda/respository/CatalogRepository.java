package com.coach.aws.lambda.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.coach.aws.lambda.domain.Catalog;

@Repository
public interface CatalogRepository extends MongoRepository<Catalog, Long> {

	@Query("{'student.$id': ?0, 'subject.$id': ?1}")
	public Catalog findByStudentIDAndSubjectID( Long studentID,  Long subjectID);
}
