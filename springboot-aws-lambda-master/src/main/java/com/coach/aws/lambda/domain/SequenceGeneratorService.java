package com.coach.aws.lambda.domain;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {

	@Autowired
	private MongoOperations mMongoOperation;
	
	/**
	 * @param sequenceName
	 * @return - Fisrt time return 1
	 */
	public long getSequenceNumber(String sequenceName) {
		
		// Get sequence number
		Query query = new Query(Criteria.where("id").is(sequenceName));
		
		// Updates the sequence
		Update update = new Update().inc("seq", 1);
		
		// Modify in document
		Sequence seq = mMongoOperation.findAndModify(query, update,
				FindAndModifyOptions.options().returnNew(true).upsert(true), Sequence.class);
		return !Objects.isNull(seq) ? seq.getSeq() : 1;
	}
	
}
