package com.coach.aws.lambda.domain;

import java.util.Date;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "institution")
public class Institution extends BaseEntity {

	@Transient
	public static final String SEQUNCE_NAME = "INSTITUTION_SEQUENCE"; 
	
	/**
	 * Short Name of institution
	 */
	String name;
	String displayName;
	String gstNo;
	String contact;
	String alternateContact;
	String email;
	Date establishedDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
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
	public Date getEstablishedDate() {
		return establishedDate;
	}
	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}
	@Override
	public String toString() {
		return "Institution [name=" + name + ", displayName=" + displayName + ", gstNo=" + gstNo + ", contact="
				+ contact + ", alternateContact=" + alternateContact + ", email=" + email + ", establishedDate="
				+ establishedDate + ", id=" + id + ", creationTime=" + creationTime + ", updateTime=" + updateTime
				+ "]";
	}
}
