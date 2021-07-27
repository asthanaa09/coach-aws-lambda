package com.coach.aws.lambda.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

/**
 * Registered institution will create their offered
 * subject and create corresponding fee structure
 * 
 * @author Anurag Asthana
 *
 */
@Document(collection = "subject")
public class Subject extends BaseEntity {
	
	public static final String SUBJECT_SEQUENCE = "subject_sequence";
	
	public enum FeeType {
		MONTHLY, QUATERLY, YEARLY
	}

	String name;
	@Field(targetType = FieldType.STRING)
	Float fee;
	FeeType feeType;
	
	@DBRef
	Institution institution;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public FeeType getFeeType() {
		return feeType;
	}

	public void setFeeType(FeeType feeType) {
		this.feeType = feeType;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
}
