package com.coach.aws.lambda.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coach.aws.lambda.respository.CatalogRepository;
import com.coach.aws.lambda.respository.StudentRepository;
import com.coach.aws.lambda.respository.SubjectRepository;

@Service
public class CatalogService {

	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CatalogRepository catalogRepository;
	@Autowired
	SequenceGeneratorService sequenceGenerator;
	
	public CatalogService(SubjectRepository subjectRepository, StudentRepository studentRepository,
			CatalogRepository catalogRepository, SequenceGeneratorService sequenceGenerator) {
		super();
		this.subjectRepository = subjectRepository;
		this.studentRepository = studentRepository;
		this.catalogRepository = catalogRepository;
		this.sequenceGenerator = sequenceGenerator;
	}

	public void updateCart(Long studentID, String subjectIDs) {
		String[] subjectsIds = subjectIDs.split(",");
		List<Long> ids = new ArrayList<Long>();
		
		for(String id : subjectsIds) {
			Long catstedID = Long.parseLong(id);
			if(!ids.contains(catstedID))
				ids.add(catstedID); 
		}
		
		List<Subject> subjects = (List<Subject>) subjectRepository.findAllById(ids);
		Student student = studentRepository.findById(studentID).orElseThrow(() -> new RuntimeException("Invalid student id"));
		
		List<Catalog> catalogs = new ArrayList<Catalog>();
		
		for (Subject subject : subjects) {
			Catalog catalog = new Catalog();
			catalog.setId(sequenceGenerator.getSequenceNumber(Catalog.SEQUENCE_KEY));
			catalog.setStudent(student);
			catalog.setSubject(subject);
			catalogs.add(catalog);
		}
		
		catalogRepository.saveAll(catalogs);
	}
	
	public void deleted(Long studentID, Long subjectID) {
		Catalog catalog = catalogRepository.findByStudentIDAndSubjectID(studentID, subjectID);
		catalog.setRemoved(true);
		catalogRepository.save(catalog);
	}
}
