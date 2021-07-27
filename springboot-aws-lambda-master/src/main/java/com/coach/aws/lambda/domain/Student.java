package com.coach.aws.lambda.domain;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student extends BaseEntity {

	private String firstName;
	private String midName;
	private String lastName;
	/**
	 * Unique based on contact, student membership will be accessible
	 */
	private String contact;
	private String alternateContact;
	private String email;
	/**
	 * TODO: Use Student Extras to store extra information about student
	 */
	private String fathersContact;
	
	@DBRef
	List<Institute> memberships;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAlternateContact() {
		return alternateContact;
	}

	public void setAlternateContact(String alternateContact) {
		this.alternateContact = alternateContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFathersContact() {
		return fathersContact;
	}

	public void setFathersContact(String fathersContact) {
		this.fathersContact = fathersContact;
	}

	public List<Institute> getMemberships() {
		return memberships;
	}

	public void setMemberships(List<Institute> memberships) {
		this.memberships = memberships;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", midName=" + midName + ", lastName=" + lastName + ", contact="
				+ contact + ", alternateContact=" + alternateContact + ", email=" + email + ", fathersContact="
				+ fathersContact + ", memberships=" + memberships + ", id=" + id + ", creationTime=" + creationTime
				+ ", updateTime=" + updateTime + "]";
	}
}
