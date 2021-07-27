package com.coach.aws.lambda.domain;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "institute_branch")
public class Institute extends BaseEntity {

	@Transient
	public static final String SEQUENCE_KEY = "institute_sequence";
	
	String name;
	String displayName;
	String gstNo;
	String contactNumber;
	String alternateContact;
	String email;
	String address;
	/**
	 * Head office of Institution
	 */
	boolean isMainBranch;
	@DBRef
	Institution institution;
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isMainBranch() {
		return isMainBranch;
	}
	public void setMainBranch(boolean isMainBranch) {
		this.isMainBranch = isMainBranch;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	@Override
	public String toString() {
		return "Institute [name=" + name + ", displayName=" + displayName + ", gstNo=" + gstNo + ", contactNumber="
				+ contactNumber + ", alternateContact=" + alternateContact + ", email=" + email + ", address=" + address
				+ ", isMainBranch=" + isMainBranch + ", institution=" + institution + ", id=" + id + ", creationTime="
				+ creationTime + ", updateTime=" + updateTime + "]";
	}
}
