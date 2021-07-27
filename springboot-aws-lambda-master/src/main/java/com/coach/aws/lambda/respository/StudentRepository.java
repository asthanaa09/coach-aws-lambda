package com.coach.aws.lambda.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.coach.aws.lambda.domain.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

}
